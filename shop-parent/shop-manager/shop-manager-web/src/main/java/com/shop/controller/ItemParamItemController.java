package com.shop.controller;

import com.shop.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: chaodong.xi
 * @since: 2018/2/8
 */

@Controller
public class ItemParamItemController {

    @Autowired
    private ItemParamItemService itemParamItemService;

    @RequestMapping(value = "/show/item/{itemId}", method = RequestMethod.GET)
    public String showItemParam(@PathVariable Long itemId, Model model){
        String itemParamForm = itemParamItemService.getItemParamByItemId(itemId);
        model.addAttribute("itemParamForm", itemParamForm);
        return "item";
    }
}
