package com.shop.rest.service.impl;

import com.shop.common.utils.CollectionUtils;
import com.shop.common.utils.JsonUtils;
import com.shop.common.utils.ShopResponse;
import com.shop.common.utils.StringUtils;
import com.shop.mapper.ItemDescMapper;
import com.shop.mapper.ItemMapper;
import com.shop.mapper.ItemParamItemMapper;
import com.shop.pojo.Item;
import com.shop.pojo.ItemDesc;
import com.shop.pojo.ItemParamItem;
import com.shop.pojo.ItemParamItemExample;
import com.shop.rest.dao.impl.JedisClientCluster;
import com.shop.rest.service.ItemService;
import javafx.scene.text.TextBoundsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private ItemParamItemMapper itemParamItemMapper;
    @Autowired
    private JedisClientCluster jedisClientCluster;
    @Value("${REDIS_ITEM_KEY}")
    private String REDIS_ITEM_KEY;
    @Value("${REDIS_ITEM_EXPIRE}")
    private Integer REDIS_ITEM_EXPIRE;

    @Override
    public ShopResponse getItemBaseInfo(long itemId) {

        try {
            String itemInfoCache = jedisClientCluster.get(REDIS_ITEM_KEY + ":" + itemId + ":base");
            if (!StringUtils.isNullOrEmpty(itemInfoCache)) {
                Item item = JsonUtils.jsonToPojo(itemInfoCache, Item.class);
                return ShopResponse.ok(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Item item = itemMapper.selectByPrimaryKey(itemId);

        try {
            jedisClientCluster.set(REDIS_ITEM_KEY + ":" + itemId + ":base", JsonUtils.objectToJson(item));
            jedisClientCluster.expire(REDIS_ITEM_KEY + ":" + itemId + ":base", REDIS_ITEM_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ShopResponse.ok(item);
    }

    @Override
    public ShopResponse getItemDesc(long itemId) {

        try {
            String itemDescCache = jedisClientCluster.get(REDIS_ITEM_KEY + ":" + itemId + ":desc");
            if (!StringUtils.isNullOrEmpty(itemDescCache)) {
                ItemDesc itemDesc = JsonUtils.jsonToPojo(itemDescCache, ItemDesc.class);
                return ShopResponse.ok(itemDesc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);

        //TODO AOP抽取切面
        try {
            jedisClientCluster.set(REDIS_ITEM_KEY + ":" + itemId + ":desc", JsonUtils.objectToJson(itemDesc));
            jedisClientCluster.expire(REDIS_ITEM_KEY + ":" + itemId + ":desc", REDIS_ITEM_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ShopResponse.ok(itemDesc);
    }

    @Override
    public ShopResponse getItemParam(long itemId) {

        try {
            String itemParamCache = jedisClientCluster.get(REDIS_ITEM_KEY + ":" + itemId + ":param");
            if (!StringUtils.isNullOrEmpty(itemParamCache)) {
                ItemParamItem itemParamItem = JsonUtils.jsonToPojo(itemParamCache, ItemParamItem.class);
                return ShopResponse.ok(itemParamItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ItemParamItemExample example = new ItemParamItemExample();
        ItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<ItemParamItem> itemParamItems = itemParamItemMapper.selectByExampleWithBLOBs(example);

        if (!CollectionUtils.listIsNullOrEmpty(itemParamItems)) {
            ItemParamItem itemParamItem = itemParamItems.get(0);

            try {
                jedisClientCluster.set(REDIS_ITEM_KEY + ":" + itemId + ":param", JsonUtils.objectToJson(itemParamItem));
                jedisClientCluster.expire(REDIS_ITEM_KEY + ":" + itemId + ":param", REDIS_ITEM_EXPIRE);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return ShopResponse.ok(itemParamItem);
        }
        return ShopResponse.build(400, "无此商品规格");
    }
}
