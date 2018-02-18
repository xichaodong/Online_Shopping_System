package com.shop.controller;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.ItemParam;
import com.shop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: chaodong.xi
 * @since: 2018/2/7
 */

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping(value = "/query/itemcatid/{itemCatId}", method = RequestMethod.GET)
    @ResponseBody
    public ShopResponse getItemParamByCid(@PathVariable Long itemCatId) {
        return itemParamService.getItemParamByCid(itemCatId);
    }

    @RequestMapping(value = "/save/{cid}", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse insertItemParam(@PathVariable Long cid, String paramData) {
        ItemParam itemParam = new ItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        ShopResponse shopResponse = itemParamService.insertItemParam(itemParam);
        return shopResponse;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public EUDataGridResult getItemParamList(Integer page, Integer rows){
        return itemParamService.getItemParamList(page, rows);
    }

}
