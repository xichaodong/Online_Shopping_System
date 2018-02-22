package com.shop.portal.controller;

import com.shop.portal.pojo.ItemInfo;
import com.shop.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public String showItem(@PathVariable Long itemId, Model model) {
        ItemInfo itemInfo = itemService.getItemById(itemId);
        model.addAttribute("item", itemInfo);
        return "item";
    }

    @RequestMapping(value = "/item/desc/{itemId}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    public String getItemDesc(@PathVariable Long itemId) {
        return itemService.getItemDescById(itemId);
    }

    @RequestMapping(value = "/item/param/{itemId}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    public String getItemParam(@PathVariable Long itemId) {
        return itemService.getItemParamById(itemId);
    }
}
