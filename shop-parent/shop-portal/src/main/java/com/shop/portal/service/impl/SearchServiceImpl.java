package com.shop.portal.service.impl;

import com.shop.common.utils.HttpClientUtil;
import com.shop.common.utils.ShopResponse;
import com.shop.portal.pojo.SearchResult;
import com.shop.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;
    @Override
    public SearchResult search(String queryString, int page) {
        Map<String, String> param = new HashMap<>();
        param.put("q", queryString);
        param.put("page", String.valueOf(page));

        try {
            String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
            ShopResponse shopResponse = ShopResponse.formatToPojo(json, SearchResult.class);
            if(shopResponse.getStatus() == 200){
                return (SearchResult) shopResponse.getData();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new SearchResult();
    }
}
