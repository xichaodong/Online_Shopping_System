package com.shop.portal.service;

import com.shop.pojo.User;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: chaodong.xi
 * @since: 2018/2/23
 */
public interface UserService {

    User getUserByToken(String token);
}
