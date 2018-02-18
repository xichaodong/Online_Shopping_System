package com.shop.service.impl;

import com.shop.common.pojo.EUTreeNode;
import com.shop.mapper.ItemCatMapper;
import com.shop.pojo.ItemCat;
import com.shop.pojo.ItemCatExample;
import com.shop.pojo.ItemCatExample.Criteria;
import com.shop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/4
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<EUTreeNode> getItemCatList(long parentId){
        ItemCatExample example = new ItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<ItemCat> catList = itemCatMapper.selectByExample(example);
        List<EUTreeNode> euTreeNodeList = new ArrayList<>();

        catList.forEach(itemCat -> {
            EUTreeNode node = new EUTreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent() ? "closed" : "open");
            euTreeNodeList.add(node);
        });
        return euTreeNodeList;
    }
}
