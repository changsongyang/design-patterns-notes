package com.github.design.proxy.mybatis_spring.factory;
import com.github.design.proxy.mybatis_spring.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 功能描述:  将Bean定义注册到Spring容器
 */
@Component
public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {


    /**
     * 该方法用来注册更多的bean到spring容器中
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        // 定义一个bean的基本信息
        System.out.println("---------------------- 定义一个bean的基本信息--------------------------------------");
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        // 指定注册bean对应的类为MapperFactoryBean
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setScope("singleton");
        // 获取MapperFactoryBean的构造函数 并赋值
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);

        // BeanDefinitionHolder封装了BeanDefinition,beanName以及aliases
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userMapper");

        //registry是DefaultBeanDefinitionDocumentReader的XmlReaderContext属性中获取SimpleBeanDefinitionRegistry对象
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, beanDefinitionRegistry);
    }

    /**
     * 该方法的实现中，主要用来对bean定义做一些改变
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
