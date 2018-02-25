package com.shop.portal.service.impl;

import com.shop.common.utils.HttpClientUtil;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.User;
import com.shop.portal.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: chaodong.xi
 * @since: 2018/2/23
 */

@Service
public class UserServiceImpl implements UserService {

    @Value("${COOKIE_SHOP_NAME}")
    public String COOKIE_SHOP_NAME;
    @Value("${SSO_PAGE_LOGIN}")
    public String SSO_PAGE_LOGIN;
    @Value("${SSO_BASE_URL}")
    public String SSO_BASE_URL;
    @Value("${SSO_USER_TOKEN}")
    private String SSO_USER_TOKEN;
    @Value("${PORTAL_BASE_URL}")
    public String PORTAL_BASE_URL;

    @Override
    public User getUserByToken(String token) {

        try {
            String test = SSO_BASE_URL + SSO_USER_TOKEN + token;
            String userInfo = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
            ShopResponse response = ShopResponse.formatToPojo(userInfo, User.class);
            if (response.getStatus() == 200) {
                return (User) response.getData();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
