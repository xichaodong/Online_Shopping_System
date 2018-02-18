package com.shop.controller;

import com.shop.common.pojo.EUTreeNode;
import com.shop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chaodong.xi
 * @since: 2018/2/4
 */

@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/item/cat/list", method = RequestMethod.POST)
    @ResponseBody
    public List<EUTreeNode> getCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId){
        return itemCatService.getItemCatList(parentId);
    }
}
