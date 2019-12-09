package com.github.design.strategy.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * 功能描述:  在非spring管理的类中获取spring注册的bean
 * @author: qinxuewu
 * @date: 2019/12/9 14:52
 * @since 1.0.0
 */
public class SpringBeanUtils   implements ApplicationContextAware {
    protected final static Log logger = LogFactory.getLog(SpringBeanUtils.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        if (applicationContext == null) {
            applicationContext = context;
        }
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {

        return applicationContext.getBean(clazz);
    }

}
