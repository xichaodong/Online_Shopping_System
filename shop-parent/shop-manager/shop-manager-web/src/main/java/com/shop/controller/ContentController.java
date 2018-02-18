package com.shop.controller;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.Content;
import com.shop.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: chaodong.xi
 * @since: 2018/2/13
 */

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    @ResponseBody
    public EUDataGridResult getContentList(int page, int rows) {
        return contentService.getContentList(page, rows);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse insertContent(Content content) {
        return contentService.insertContent(content);
    }


}
