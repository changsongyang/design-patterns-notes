package com.github.design.proxy.mybatis_spring.annotation;


import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    String value() default "";  // sql语句
}
