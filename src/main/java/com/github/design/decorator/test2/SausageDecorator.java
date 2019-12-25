package com.github.design.decorator.test2;


/**
 * 功能描述: 香肠装饰类
 * @author: qinxuewu
 * @date: 2019/12/25 11:11
 * @since 1.0.0
 */
public class SausageDecorator extends  BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() { }

    @Override
    protected String getName() {
        return super.getName()+"+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+2;
    }
}
