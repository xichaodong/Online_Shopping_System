package com.shop.rest.service.impl;

import com.shop.common.utils.JsonUtils;
import com.shop.common.utils.StringUtils;
import com.shop.mapper.ItemCatMapper;
import com.shop.pojo.ItemCat;
import com.shop.pojo.ItemCatExample;
import com.shop.rest.dao.impl.JedisClientCluster;
import com.shop.rest.pojo.CatNode;
import com.shop.rest.pojo.CatResult;
import com.shop.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/9
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;
    @Autowired
    private JedisClientCluster jedisClientCluster;
    @Value("${INDEX_CAT_REDIS_KEY}")
    private String INDEX_CAT_REDIS_KEY;

    @Override
    public CatResult getItemCatList() {

        try{
            String oldCache = jedisClientCluster.get(INDEX_CAT_REDIS_KEY);
            if(!StringUtils.isNullOrEmpty(oldCache)){
                return JsonUtils.jsonToPojo(oldCache, CatResult.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        CatResult catResult = new CatResult();
        catResult.setData(getCatList(0));

        try{
            String newCache = JsonUtils.objectToJson(catResult);
            jedisClientCluster.set(INDEX_CAT_REDIS_KEY, newCache);
        }catch (Exception e){
            e.printStackTrace();
        }
        return catResult;
    }

    private List<?> getCatList(long parentId) {
        ItemCatExample itemCatExample = new ItemCatExample();
        ItemCatExample.Criteria criteria = itemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ItemCat> itemCatList = itemCatMapper.selectByExample(itemCatExample);

        List<Object> catNodeList = new ArrayList<>();
        int catCount = 0;

        for(ItemCat itemCat  : itemCatList) {
            if (itemCat.getIsParent()) {
                CatNode catNode = new CatNode();
                if (parentId == 0) {
                    catNode.setName("<a href='/products/" + itemCat.getId() + ".html'>" + itemCat.getName() + "</a>");
                } else {
                    catNode.setName(itemCat.getName());
                }
                catNode.setUrl("/products/" + itemCat.getId() + ".html");
                catNode.setItem(getCatList(itemCat.getId()));

                catNodeList.add(catNode);
                catCount++;
                if(parentId == 0 && catCount == 14){
                    break;
                }
            } else {
                catNodeList.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
            }
        }
        return catNodeList;
    }
}
