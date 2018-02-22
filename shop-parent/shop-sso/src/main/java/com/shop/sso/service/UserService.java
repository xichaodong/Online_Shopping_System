package com.shop.sso.service;

import com.shop.common.utils.ShopResponse;
import com.shop.pojo.User;

public interface UserService {
    ShopResponse checkData(String content, Integer type);
    ShopResponse createUser(User user);
    ShopResponse userLogin(String username, String password);
    ShopResponse getUserInfo(String token);
}
