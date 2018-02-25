package com.shop.portal.controller;

import com.shop.common.utils.ShopResponse;
import com.shop.portal.pojo.CartItem;
import com.shop.portal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/25
 */

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add/{itemId}", method = RequestMethod.POST)
    public String addCartItem(@PathVariable Long itemId,
                              @RequestParam(defaultValue = "1") Integer num,
                              HttpServletRequest request, HttpServletResponse response) {

        cartService.addCartItem(itemId, num, request, response);
        return "redirect:/cart/success.html";
    }

    @RequestMapping(value = "success", method = RequestMethod.GET)
    public String showSuccess() {
        return "cartSuccess";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<CartItem> cartItems = cartService.getCartItemList(request, response);
        model.addAttribute("cartList", cartItems);
        return "cart";
    }

    @RequestMapping(value = "/delete/{itemId}", method = RequestMethod.GET)
    public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
        cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart.html";
    }
}
