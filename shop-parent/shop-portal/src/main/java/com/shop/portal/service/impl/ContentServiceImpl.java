package com.shop.portal.service.impl;

import com.shop.common.utils.HttpClientUtil;
import com.shop.common.utils.JsonUtils;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.Content;
import com.shop.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chaodong.xi
 * @since: 2018/2/14
 */

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Override
    public String getContentList() {
        String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
        try {
            ShopResponse shopResponse = ShopResponse.formatToList(result, Content.class);
            List<Content> contentList = (List<Content>) shopResponse.getData();
            List<Map<String, Object>> resultList = new ArrayList<>();

            contentList.forEach(content -> {
                Map<String, Object> contentMap = new HashMap<>();
                contentMap.put("src",content.getPic());
                contentMap.put("height", 240);
                contentMap.put("width", 670);
                contentMap.put("srcB",content.getPic2());
                contentMap.put("heightB", 550);
                contentMap.put("widthB", 240);
                contentMap.put("href", content.getUrl());
                contentMap.put("alt", content.getSubTitle());
                resultList.add(contentMap);
            });
            return JsonUtils.objectToJson(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
