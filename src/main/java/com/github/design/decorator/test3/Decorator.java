package com.github.design.decorator.test3;

// 装修基本类
public class Decorator  implements IDecorator{
    /**
     * 基本实现方法
     */
    @Override
    public void decorate() {
        System.out.println("水电装修、天花板以及粉刷墙。。。");
    }
}
