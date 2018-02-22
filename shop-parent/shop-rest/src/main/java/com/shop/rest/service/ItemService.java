package com.shop.rest.service;

import com.shop.common.utils.ShopResponse;

public interface ItemService {

    ShopResponse getItemBaseInfo(long itemId);
    ShopResponse getItemDesc(long itemId);
    ShopResponse getItemParam(long itemId);
}
