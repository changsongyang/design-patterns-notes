package com.github.design.strategy.spring;
import java.lang.annotation.*;

/**
 * 功能描述: 消息类型注册类
 * @author: qinxuewu
 * @date: 2019/12/9 14:33
 * @since 1.0.0
 * 声明的此注解使用了Inherited元注解，表示此注解用在类上时，会被子类所继承
 */


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MsgTypeAnnotation {

    MsgTypeEnum msgType();
}
