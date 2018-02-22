package com.shop.common.utils;

import java.util.List;

public class CollectionUtils {
    public static boolean listIsNullOrEmpty(List list){
        return list == null || list.size() == 0;
    }
}
