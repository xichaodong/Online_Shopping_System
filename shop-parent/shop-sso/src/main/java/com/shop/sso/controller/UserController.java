package com.shop.sso.controller;

import com.shop.common.utils.ExceptionUtil;
import com.shop.common.utils.JsonUtils;
import com.shop.common.utils.ShopResponse;
import com.shop.common.utils.StringUtils;
import com.shop.pojo.User;
import com.shop.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check/{param}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Object checkData(@PathVariable String param, @PathVariable Integer type, String callback) {

        ShopResponse response = null;

        if (StringUtils.isNullOrEmpty(param)) {
            response = ShopResponse.build(400, "校验内容不能为空");
        }
        if (type == null) {
            response = ShopResponse.build(400, "校验类型不能为空");
        }
        if (type != 1 && type != 2 && type != 3) {
            response = ShopResponse.build(400, "校验类型错误");
        }

        if (response != null) {
            return JsonUtils.jsonpResponse(callback, response);
        }

        try {
            response = userService.checkData(param, type);
        } catch (Exception e) {
            response = ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }

        return JsonUtils.jsonpResponse(callback, response);
    }

    //TODO 加salt
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse createUser(User user) {
        try {
            return userService.createUser(user);
        } catch (Exception e) {
            return ShopResponse.build(400, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        try{
            return userService.userLogin(username, password, request, response);
        }catch (Exception e){
            return ShopResponse.build(400, ExceptionUtil.getStackTrace(e));
        }
    }

    @RequestMapping(value = "/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserInfo(@PathVariable String token, String callback){

        ShopResponse response = null;
        try{
            response = userService.getUserInfo(token);
        }catch (Exception e){
            response = ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }

        return JsonUtils.jsonpResponse(callback, response);


    }
}
