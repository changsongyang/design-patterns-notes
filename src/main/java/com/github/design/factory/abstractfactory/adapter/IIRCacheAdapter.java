package com.github.design.factory.abstractfactory.adapter;

import com.github.design.factory.abstractfactory.redis.IIR;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:   IIR集群适配实现方法，
 * 作用：统一方法名调用，适配同集群的不同方法名词
 * @author: qinxuewu
 */
public class IIRCacheAdapter  implements  ICacheAdapter{

    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
