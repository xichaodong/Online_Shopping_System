package com.shop.sso.service;

import com.shop.common.utils.ShopResponse;
import com.shop.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ShopResponse checkData(String content, Integer type);
    ShopResponse createUser(User user);
    ShopResponse userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
    ShopResponse getUserInfo(String token);
}
