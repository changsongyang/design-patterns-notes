package com.github.design.proxy.mybatis_spring.factory;

import com.github.design.proxy.mybatis_spring.annotation.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *  代理类定义
 * @param <T>
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {
    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 提供类的代理以及模拟对sql语句的处理，这里包含了用户调用dao层方法时候的处理逻辑。
     */
    @Override
    public T getObject() throws Exception {

        InvocationHandler handler=(proxy, method, args) ->{
            // 获取加油Select注解的方法
            Select select=method.getAnnotation(Select.class);
            // SQL语句参数组装  查询数据库
            logger.info("SQL转换：{}", select.value().replace("#{uId}", args[0].toString()));

            // 模拟SQL语句查询返回的值 queryUserInfo返回的值
            return args[0]+" 模拟SQL语句查询返回的值";
        };
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperInterface},handler);
    }

    // 提供对象类型反馈
    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
