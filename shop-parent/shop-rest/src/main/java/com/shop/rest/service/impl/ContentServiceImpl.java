package com.shop.rest.service.impl;

import com.mysql.jdbc.StringUtils;
import com.shop.common.utils.JsonUtils;
import com.shop.mapper.ContentMapper;
import com.shop.pojo.Content;
import com.shop.pojo.ContentExample;
import com.shop.rest.dao.impl.JedisClientCluster;
import com.shop.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/13
 */

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private JedisClientCluster jedisClientCluster;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Override
    public List<Content> getContentList(long categoryId) {

        try {
            String oldCache = jedisClientCluster.hGet(INDEX_CONTENT_REDIS_KEY, String.valueOf(categoryId));
            if (!StringUtils.isNullOrEmpty(oldCache)) {
                return JsonUtils.jsonToList(oldCache, Content.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<Content> contentList = contentMapper.selectByExample(example);

        try {
            String newCache = JsonUtils.objectToJson(contentList);
            jedisClientCluster.hSet(INDEX_CONTENT_REDIS_KEY, String.valueOf(categoryId), newCache);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentList;
    }
}
