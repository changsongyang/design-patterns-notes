package com.github.design.factory.abstractfactory.adapter;

import com.github.design.factory.abstractfactory.redis.EGM;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:   EGM集群适配实现方法，
 * 作用：统一方法名调用，适配同集群的不同方法名词
 * @author: qinxuewu
 */
public class EGMCacheAdapter  implements  ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    
    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
