package com.shop.service;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.ItemParam;

/**
 * @author: chaodong.xi
 * @since: 2018/2/7
 */
public interface ItemParamService {
    ShopResponse getItemParamByCid(long cid);
    ShopResponse insertItemParam(ItemParam itemParam);
    EUDataGridResult getItemParamList(int page, int rows);
}
