package com.shop.controller;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.Item;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: chaodong.xi
 * @since: 2018/2/3
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }

    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    private ShopResponse createItem(Item item, String desc, String itemParams) {
        return itemService.createItem(item, desc, itemParams);
    }
}
