package com.shop.common.utils;

public class StringUtils {

    public static boolean isNullOrEmpty(String toTest) {
        return (toTest == null || toTest.length() == 0);
    }
}
