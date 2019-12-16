package com.github.design.strategy.spring;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import java.util.Map;



/**
 * 功能描述: 策略处理器
 * @author: qinxuewu
 * @date: 2019/12/9 14:56
 * @since 1.0.0
 */
@Component
public class StrategyProcessor implements BeanFactoryPostProcessor {
    private static final String STRATEGY_PACKAGE = "com.github.design.strategy.spring";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<MsgTypeEnum, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        // 扫描制定的类
        ClassScanner.scan(STRATEGY_PACKAGE, MsgTypeAnnotation.class).forEach(clazz -> {
            System.out.println(clazz.getName());
            // 获取注解中的类型值
            MsgTypeEnum type = clazz.getAnnotation(MsgTypeAnnotation.class).msgType();
            handlerMap.put(type, clazz);

        });
        System.out.println(handlerMap.toString());
        // 初始化HandlerContext,将其注册到spring容器中
        StrategyContext context = new StrategyContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(StrategyContext.class.getName(), context);
    }
}
