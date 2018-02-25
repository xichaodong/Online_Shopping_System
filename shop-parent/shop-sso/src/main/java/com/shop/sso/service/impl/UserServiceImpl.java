package com.shop.sso.service.impl;

import com.shop.common.utils.*;
import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.pojo.UserExample;
import com.shop.sso.dao.impl.JedisClientCluster;
import com.shop.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JedisClientCluster jedisClientCluster;
    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;
    @Value("${COOKIE_SHOP_NAME}")
    private String COOKIE_SHOP_NAME;

    //TODO 替换Enum
    @Override
    public ShopResponse checkData(String content, Integer type) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (type == 1) {
            criteria.andUsernameEqualTo(content);
        } else if (type == 2) {
            criteria.andPhoneEqualTo(content);
        } else {
            criteria.andEmailEqualTo(content);
        }
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionUtils.listIsNullOrEmpty(userList)) {
            return ShopResponse.ok(true);
        }

        return ShopResponse.ok(false);
    }

    @Override
    public ShopResponse createUser(User user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        boolean insertResult = userMapper.insert(user) > 0;
        return insertResult ? ShopResponse.ok() : ShopResponse.build(400, "用户注册失败");
    }

    @Override
    public ShopResponse userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionUtils.listIsNullOrEmpty(userList)) {
            return ShopResponse.build(400, "用户名错误");
        }

        User user = userList.get(0);
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return ShopResponse.build(400, "密码错误");
        }

        String token = UUID.randomUUID().toString();
        user.setPassword(null);
        jedisClientCluster.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
        jedisClientCluster.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        CookieUtils.setCookie(request, response, COOKIE_SHOP_NAME, token);
        return ShopResponse.ok(token);
    }

    @Override
    public ShopResponse getUserInfo(String token) {
        String userInfo = jedisClientCluster.get(REDIS_USER_SESSION_KEY + ":" + token);
        if(StringUtils.isNullOrEmpty(userInfo)){
            return ShopResponse.build(400, "此session已经过期，请重新登录");
        }
        jedisClientCluster.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        return ShopResponse.ok(JsonUtils.jsonToPojo(userInfo, User.class));
    }
}
