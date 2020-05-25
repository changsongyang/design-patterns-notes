package com.github.design.factory.abstractfactory.adapter;


import java.util.concurrent.TimeUnit;

/**
 * 功能描述:  Redis缓存适配器接口
 * 作用：让所有集群的提供方(也就是各种Redis集群操作工具类)，能在统一的方法名称下进行操作。也方面后续的拓展。
 * @author: qinxuewu
 */
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
