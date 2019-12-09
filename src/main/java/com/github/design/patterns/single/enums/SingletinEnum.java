package com.github.design.patterns.single.enums;

/**
 * 枚举类-实现单例模式
 *  - 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 *  - Effective Java作者Josh Bloch 提倡的方式
 *
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 4:10
 */
public enum  SingletinEnum {
    INSTANCE; //属性
    public void sayOK() {
        System.out.println("ok~");
    }
}
