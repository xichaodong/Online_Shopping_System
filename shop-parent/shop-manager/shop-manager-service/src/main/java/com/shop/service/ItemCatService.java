package com.shop.service;

import com.shop.common.pojo.EUTreeNode;
import com.shop.pojo.ItemCat;

import java.util.List;

/**
 * @author: chaodong.xi
 * @since: 2018/2/4
 */
public interface ItemCatService {

    public List<EUTreeNode> getItemCatList(long parentId);
}
