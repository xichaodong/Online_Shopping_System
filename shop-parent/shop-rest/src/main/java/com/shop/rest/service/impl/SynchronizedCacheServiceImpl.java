package com.shop.rest.service.impl;

import com.shop.common.utils.ExceptionUtil;
import com.shop.common.utils.ShopResponse;
import com.shop.rest.dao.impl.JedisClientCluster;
import com.shop.rest.service.SynchronizedCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SynchronizedCacheServiceImpl implements SynchronizedCacheService {

    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    @Value("${INDEX_CAT_REDIS_KEY}")
    private String INDEX_CAT_REDIS_KEY;
    @Autowired
    private JedisClientCluster jedisClientCluster;

    @Override
    public ShopResponse synchronizedContentCache(long categoryId) {
        try{
            jedisClientCluster.hDel(INDEX_CONTENT_REDIS_KEY, String.valueOf(categoryId));
        }catch (Exception e){
            e.printStackTrace();
            return ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }
        return ShopResponse.ok();
    }

    @Override
    public ShopResponse synchronizedCatCache() {
        try{
            jedisClientCluster.del(INDEX_CAT_REDIS_KEY);
        }catch (Exception e){
            e.printStackTrace();
            return ShopResponse.build(500, ExceptionUtil.getStackTrace(e));
        }
        return ShopResponse.ok();
    }
}
