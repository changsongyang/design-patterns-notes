package com.github.design.factory.abstractfactory.service;

import com.github.design.factory.abstractfactory.redis.RedisUtils;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl  implements CacheService  {
    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}