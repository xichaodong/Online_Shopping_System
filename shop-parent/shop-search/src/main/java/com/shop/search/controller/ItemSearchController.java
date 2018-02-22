package com.shop.search.controller;

import com.shop.common.utils.ExceptionUtil;
import com.shop.common.utils.ShopResponse;
import com.shop.common.utils.StringUtils;
import com.shop.search.pojo.SearchResult;
import com.shop.search.service.ItemSearchService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemSearchController {
    @Autowired
    private ItemSearchService itemSearchService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public ShopResponse search(@RequestParam("q") String queryString,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "60") Integer rows){
        if(StringUtils.isNullOrEmpty(queryString)){
            return ShopResponse.build(400, "查询条件不能为空");
        }

        SearchResult searchResult;

        try {
            searchResult = itemSearchService.search(queryString, page ,rows);
        } catch (SolrServerException e) {
            e.printStackTrace();
            return ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }
        return ShopResponse.ok(searchResult);
    }
}
