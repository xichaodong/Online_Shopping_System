package com.shop.portal.controller;

import com.shop.portal.pojo.SearchResult;
import com.shop.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("q") String queryString, @RequestParam(defaultValue = "1") Integer page, Model model) {
        SearchResult searchResult = searchService.search(queryString, page);
        model.addAttribute("query", queryString);
        model.addAttribute("totalPages", searchResult.getPageCount());
        model.addAttribute("itemList", searchResult.getItemSearchList());
        model.addAttribute("page", page);

        return "search";
    }

}
