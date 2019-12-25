package com.github.design.decorator.test2;


/**
 * 功能描述:  鸡蛋的装饰着
 * @author: qinxuewu
 * @date: 2019/12/25 11:09
 * @since 1.0.0
 */
public class EggDecorator extends  BattercakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }
    @Override
    protected void doSomething() { }

    @Override
    protected String getName() {
        return super.getName()+"+ 1个鸡蛋";
    }
    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
