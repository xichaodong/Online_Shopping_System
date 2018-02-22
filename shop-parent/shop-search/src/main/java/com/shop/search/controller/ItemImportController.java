package com.shop.search.controller;

import com.shop.common.utils.ShopResponse;
import com.shop.search.service.ItemImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager")
public class ItemImportController {
    @Autowired
    private ItemImportService itemImportService;

    @RequestMapping(value = "/importall", method = RequestMethod.GET)
    @ResponseBody
    public ShopResponse importAllItems(){
        return itemImportService.importAllItems();
    }
}
