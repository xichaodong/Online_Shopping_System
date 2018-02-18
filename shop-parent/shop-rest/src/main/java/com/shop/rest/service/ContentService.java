package com.shop.rest.service;

import com.shop.pojo.Content;

import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/13
 */
public interface ContentService {

    List<Content> getContentList(long categoryId);
}
