package com.shop.controller;

import com.shop.common.pojo.EUTreeNode;
import com.shop.common.utils.ShopResponse;
import com.shop.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/10
 */

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return contentCategoryService.getCategoryList(parentId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse createContentCategory(Long parentId, String name) {
        return contentCategoryService.insertContentCategory(parentId, name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse deleteContentCategory(Long id) {
        return contentCategoryService.deleteContentCategory(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse renameContentCategory(Long id, String name) {
        return contentCategoryService.renameContentCategory(id, name);
    }
}
