package com.github.design.factory.abstractfactory.service;

import java.util.concurrent.TimeUnit;


/**
 * 功能描述:  统一缓存接口
 * @author: qinxuewu
 */
public interface CacheService {
    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
