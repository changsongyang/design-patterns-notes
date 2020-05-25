package com.github.design.factory;

import com.github.design.factory.abstractfactory.JDKProxy;
import com.github.design.factory.abstractfactory.adapter.EGMCacheAdapter;
import com.github.design.factory.abstractfactory.adapter.IIRCacheAdapter;
import com.github.design.factory.abstractfactory.service.CacheService;
import com.github.design.factory.abstractfactory.service.CacheServiceImpl;

public class TestCacheService {

    // 通过传入不同的集群类型，就可以调用不同的集群下的方法
    public static void main(String[] args) throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);


        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01","小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }
}
