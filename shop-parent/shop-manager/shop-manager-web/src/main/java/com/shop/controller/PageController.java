package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: chaodong.xi
 * @since: 2018/2/3
 */

@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String showPage(@PathVariable String pageName) {
        return pageName;
    }
}
