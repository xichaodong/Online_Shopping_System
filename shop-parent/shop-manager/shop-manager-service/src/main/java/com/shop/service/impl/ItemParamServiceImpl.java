package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.mapper.ItemCatMapper;
import com.shop.mapper.ItemParamMapper;
import com.shop.pojo.ItemCatExample;
import com.shop.pojo.ItemParam;
import com.shop.pojo.ItemParamExample;
import com.shop.pojo.ItemParamExample.Criteria;
import com.shop.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/7
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private ItemParamMapper itemParamMapper;
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ShopResponse getItemParamByCid(long cid) {
        ItemParamExample itemParamExample = new ItemParamExample();
        Criteria criteria = itemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<ItemParam> list = itemParamMapper.selectByExampleWithBLOBs(itemParamExample);
        if (!CollectionUtils.isEmpty(list)) {
            return ShopResponse.ok(list.get(0));
        }
        return ShopResponse.build(999, "无相关模板信息");
    }

    @Override
    public ShopResponse insertItemParam(ItemParam itemParam) {
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        String itemCatName = itemCatMapper.selectByPrimaryKey(itemParam.getItemCatId()).getName();
        itemParam.setItemCatName(itemCatName);
        boolean result = itemParamMapper.insert(itemParam) > 0;
        return result ? ShopResponse.ok() : ShopResponse.build(999, "商品模板插入失败");
    }

    @Override
    public EUDataGridResult getItemParamList(int page, int rows) {

        ItemParamExample example = new ItemParamExample();
        PageHelper.startPage(page, rows);
        List<ItemParam> itemParamList = itemParamMapper.selectByExampleWithBLOBs(example);
        PageInfo<ItemParam> pageInfo = new PageInfo<>(itemParamList);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setTotal(pageInfo.getTotal());
        euDataGridResult.setRows(itemParamList);

        return euDataGridResult;
    }

}
