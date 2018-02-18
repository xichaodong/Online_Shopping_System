package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.IDUtils;
import com.shop.common.utils.ShopResponse;
import com.shop.mapper.ItemDescMapper;
import com.shop.mapper.ItemMapper;
import com.shop.mapper.ItemParamItemMapper;
import com.shop.pojo.*;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chaodong.xi
 * @since 2018.02.03
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    @Override
    public Item getItemById(long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        ItemExample itemExample = new ItemExample();
        PageHelper.startPage(page, rows);
        List<Item> list = itemMapper.selectByExample(itemExample);
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(list);
        euDataGridResult.setTotal(pageInfo.getTotal());
        return euDataGridResult;
    }

    @Override
    public ShopResponse createItem(Item item, String desc, String itemParam) {
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());

        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());

        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());

        boolean insertItemResult = itemMapper.insert(item) > 0;
        boolean insertDescResult = itemDescMapper.insert(itemDesc) > 0;
        boolean insertParamResult = itemParamItemMapper.insert(itemParamItem) > 0;
        if(!insertItemResult || !insertDescResult || !insertParamResult){
            throw new RuntimeException("插入商品失败");
        }
        return ShopResponse.ok();
    }

}
