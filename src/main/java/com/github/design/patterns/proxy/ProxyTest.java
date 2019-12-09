package com.github.design.patterns.proxy;

/**
 *  静态代理
 *
 * @author qinxuewu
 * @create 19/8/29下午7:17
 * @since 1.0.0
 */


public class ProxyTest {

    public static void main(String[] args) {

        // 创建目标对象 被代理的对象
        TeacherDao teacherDao=new TeacherDao();

        // 创建代理对象 调用被代理对象的方法
        TeacherDaoProxy teacherDaoProxy=new TeacherDaoProxy(teacherDao);

        // 通过代理对象 调用被代理对象的方法
        teacherDaoProxy.teacher();;
    }
}
