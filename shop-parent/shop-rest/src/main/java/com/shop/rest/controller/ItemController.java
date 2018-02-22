package com.shop.rest.controller;

import com.shop.common.utils.ShopResponse;
import com.shop.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/info/{itemId}", method = RequestMethod.GET)
    @ResponseBody
    public ShopResponse getItemBaseInfo(@PathVariable Long itemId) {
        return itemService.getItemBaseInfo(itemId);
    }

    @RequestMapping(value = "/desc/{itemId}", method = RequestMethod.GET)
    @ResponseBody
    public ShopResponse getItemDesc(@PathVariable Long itemId) {
        return itemService.getItemDesc(itemId);
    }

    @RequestMapping(value = "/param/{itemId}", method = RequestMethod.GET)
    @ResponseBody
    public ShopResponse getItemParam(@PathVariable Long itemId) {
        return itemService.getItemParam(itemId);
    }
}
