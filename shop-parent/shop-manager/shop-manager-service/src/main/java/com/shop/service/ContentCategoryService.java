package com.shop.service;

import com.shop.common.pojo.EUTreeNode;
import com.shop.common.utils.ShopResponse;

import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/9
 */
public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);
    ShopResponse insertContentCategory(long parentId, String name);
    ShopResponse deleteContentCategory(long id);
    ShopResponse renameContentCategory(long id, String name);
}
