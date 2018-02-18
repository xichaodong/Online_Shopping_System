package com.shop.service;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.Item;

/**
 * @author chaodong.xi
 * @since 2018.02.03
 */

public interface ItemService {
    Item getItemById(long itemId);
    EUDataGridResult getItemList(int page, int rows);
    ShopResponse createItem(Item item, String desc, String itemParam);

}
