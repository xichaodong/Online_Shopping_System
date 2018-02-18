package com.shop.rest.dao.impl;

import com.shop.rest.dao.JedisCilent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @author: chaodong.xi
 * @since: 2018/2/18
 */
public class JedisClientCluster implements JedisCilent {

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String hGet(String hKey, String key) {
        return jedisCluster.hget(hKey, key);
    }

    @Override
    public Long hSet(String hKey, String key, String value) {
        return jedisCluster.hset(hKey, key, value);
    }

    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public long expire(String key, int second) {
        return jedisCluster.expire(key, second);
    }

    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public long del(String key) {
        return jedisCluster.del(key);
    }

    @Override
    public long hDel(String hKey, String key) {
        return jedisCluster.hdel(hKey, key);
    }
}
