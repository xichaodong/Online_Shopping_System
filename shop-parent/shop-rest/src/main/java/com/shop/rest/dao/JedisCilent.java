package com.shop.rest.dao;

/**
 * @author: chaodong.xi
 * @since: 2018/2/18
 */
public interface JedisCilent {

    String get(String key);
    String set(String key, String value);

    String hGet(String hKey, String key);
    Long hSet(String hKey, String key, String value);

    long incr(String key);
    long expire(String key, int second);
    long ttl(String key);
    long del(String key);
    long hDel(String hKey, String key);
}
