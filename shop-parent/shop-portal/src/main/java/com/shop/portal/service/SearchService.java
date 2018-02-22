package com.shop.portal.service;

import com.shop.portal.pojo.SearchResult;

public interface SearchService {
    SearchResult search(String queryString, int page);
}
