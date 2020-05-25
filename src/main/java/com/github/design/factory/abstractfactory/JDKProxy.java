package com.github.design.factory.abstractfactory;


import com.github.design.factory.abstractfactory.adapter.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 功能描述: 定义抽象工程代理类和实现
 * 作用：主要的作用就是完成代理类，同时对于使用哪个集群有外部通过入参进行传递。
 * @author: qinxuewu

 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
