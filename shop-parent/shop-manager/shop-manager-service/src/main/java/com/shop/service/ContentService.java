package com.shop.service;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.utils.ShopResponse;
import com.shop.pojo.Content;

/**
 * @author: chaodong.xi
 * @since: 2018/2/13
 */
public interface ContentService {
    EUDataGridResult getContentList(int page, int rows);
    ShopResponse insertContent(Content content);
}
