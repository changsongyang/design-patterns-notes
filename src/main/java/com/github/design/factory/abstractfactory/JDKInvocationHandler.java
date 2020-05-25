package com.github.design.factory.abstractfactory;
import com.github.design.factory.abstractfactory.adapter.ICacheAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 功能描述: 代理类的实现，通过穿透进来的集群服务进行方法操作
 * @author: qinxuewu
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    /**
     * 在invoke中通过使用获取方法名称反射方式，调用对应的方法功能，
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }

}
