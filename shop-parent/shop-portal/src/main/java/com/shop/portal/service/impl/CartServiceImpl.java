package com.shop.portal.service.impl;

import com.shop.common.utils.*;
import com.shop.pojo.Item;
import com.shop.portal.pojo.CartItem;
import com.shop.portal.service.CartService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/25
 */

@Service
public class CartServiceImpl implements CartService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${ITEM_INFO_URL}")
    private String ITEM_INFO_URL;
    @Value("${COOKIE_CART_NAME}")
    private String COOKIE_CART_NAME;

    @Override
    public ShopResponse addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response) {

        CartItem cartItem = null;

        List<CartItem> cartItems = getCartItemList(request);
        for (CartItem cItem : cartItems) {
            if (cItem.getId() == itemId) {
                cItem.setNum(cItem.getNum() + num);
                cartItem = cItem;
                break;
            }
        }

        if (cartItem == null) {
            cartItem = new CartItem();
            String itemInfo = HttpClientUtil.doGet(REST_BASE_URL + ITEM_INFO_URL + itemId);
            ShopResponse shopResponse = ShopResponse.formatToPojo(itemInfo, Item.class);
            if (shopResponse.getStatus() == 200) {
                Item item = (Item) shopResponse.getData();
                cartItem.setId(item.getId());
                cartItem.setImage(item.getImage() == null ? "" : item.getImage().split(",")[0]);
                cartItem.setPrice(item.getPrice());
                cartItem.setTitle(item.getTitle());
                cartItem.setNum(num);
            }
            cartItems.add(cartItem);
        }
        CookieUtils.setCookie(request, response, COOKIE_CART_NAME, JsonUtils.objectToJson(cartItems), true);
        return ShopResponse.ok();
    }

    @Override
    public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
        return getCartItemList(request);
    }

    @Override
    public ShopResponse deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
        List<CartItem> cartItems = getCartItemList(request);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId() == itemId) {
                cartItems.remove(cartItem);
                break;
            }
        }
        CookieUtils.setCookie(request, response, COOKIE_CART_NAME, JsonUtils.objectToJson(cartItems), true);
        return ShopResponse.ok();
    }

    private List<CartItem> getCartItemList(HttpServletRequest request) {
        String cartInfo = CookieUtils.getCookieValue(request, COOKIE_CART_NAME, true);
        if (StringUtils.isNullOrEmpty(cartInfo)) {
            return new ArrayList<>();
        }
        try {
            List<CartItem> cartItems = JsonUtils.jsonToList(cartInfo, CartItem.class);
            return cartItems;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
