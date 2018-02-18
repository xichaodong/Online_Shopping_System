package com.shop.rest.dao.impl;

import com.shop.rest.dao.JedisCilent;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: chaodong.xi
 * @since: 2018/2/18
 */
public class JedisClientSingle implements JedisCilent {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String status = jedis.set(key, value);
        jedis.close();
        return status;
    }

    @Override
    public String hGet(String hKey, String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.hget(hKey, key);
        jedis.close();
        return value;
    }

    @Override
    public Long hSet(String hKey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long status = jedis.hset(hKey, key, value);
        jedis.close();
        return status;
    }


    @Override
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long newValue = jedis.incr(key);
        jedis.close();
        return newValue;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long status = jedis.expire(key, second);
        jedis.close();
        return status;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long second = jedis.ttl(key);
        jedis.close();
        return second;
    }

    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long status = jedis.del(key);
        jedis.close();
        return status;
    }

    @Override
    public long hDel(String hKey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long status = jedis.hdel(hKey, key);
        jedis.close();
        return status;
    }
}
