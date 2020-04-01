package com.github.design.decorator.test3;


/**
 如果我们想要在基础类上添加新的装修功能，只需要基于抽象类BaseDecorator去实现继承类，通过构造函数调用父类，以及重写装修方法实现装修窗帘的功能即可
 基于装饰器模式实现的装修功能的代码结构简洁易读，业务逻辑也非常清晰，并且如果我们需要扩展新的装修功能，只需要新增一个继承了抽象装饰类的子类即可。
 */
public class Main {

    public static void main(String[] args) {
        IDecorator decorator = new Decorator();
        IDecorator curtainDecorator = new CurtainDecorator(decorator);
        curtainDecorator.decorate();
    }
}
