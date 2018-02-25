package com.shop.portal.service;

import com.shop.common.utils.ShopResponse;
import com.shop.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/25
 */
public interface CartService {

    ShopResponse addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

    ShopResponse deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
