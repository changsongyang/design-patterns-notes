package com.github.design.proxy.mybatis_spring;


import com.github.design.proxy.mybatis_spring.mapper.UserMapper;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * 功能描述: 启动引导类
 * @author: qinxuewu
 * @date: 2020/6/17 10:09
 * @since 1.0.0
 */
@ComponentScan(basePackages = "com.github.design.proxy.mybatis_spring.factory")
public class Bootstrap {

    public static void main(String[] args) {
        // 启动上下  设置非Web应用
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Bootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        String res = userMapper.queryUserInfo("100001");
        System.out.println("测试结果:"+res);

        userMapper.queryList(18);
        System.out.println("测试结果2:"+  userMapper.queryList(18));
    }
}
