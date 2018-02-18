package com.shop.rest.controller;

import com.shop.common.utils.ShopResponse;
import com.shop.rest.service.SynchronizedCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache/sync")
public class SynchronizedCacheController {

    @Autowired
    private SynchronizedCacheService synchronizedCacheService;

    @RequestMapping(value = "/content/{categoryId}", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse SynchronizedContentCache(@PathVariable long categoryId){
        return synchronizedCacheService.synchronizedContentCache(categoryId);
    }

    @RequestMapping(value = "/cat", method = RequestMethod.POST)
    @ResponseBody
    public ShopResponse SynchronizedContentCache(){
        return synchronizedCacheService.synchronizedCatCache();
    }
}
