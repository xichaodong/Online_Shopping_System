package com.shop.rest.controller;

import com.shop.common.utils.ExceptionUtil;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.Content;
import com.shop.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/13
 */

@Controller

@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public ShopResponse getContentList(@PathVariable Long contentCategoryId) {
        try {
            List<Content> contentList = contentService.getContentList(contentCategoryId);
            return ShopResponse.ok(contentList);
        } catch (Exception e) {
            return ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
