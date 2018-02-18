package com.shop.rest.service;

import com.shop.common.utils.ShopResponse;

public interface SynchronizedCacheService {
    ShopResponse synchronizedContentCache(long categoryId);
    ShopResponse synchronizedCatCache();
}
