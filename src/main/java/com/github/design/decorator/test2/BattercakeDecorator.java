package com.github.design.decorator.test2;


/**
 * 功能描述: 扩展套餐的抽象装饰者
 * @author: qinxuewu
 * @date: 2019/12/25 11:01
 * @since 1.0.0
 */
public abstract class BattercakeDecorator extends  Battercake {
    //静态代理， 委派
    private Battercake battercake;

    public  BattercakeDecorator(Battercake battercake){
        this.battercake=battercake;
    }
    protected abstract void doSomething();
    @Override
    protected String getName() {
        return this.battercake.getName();
    }
    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
