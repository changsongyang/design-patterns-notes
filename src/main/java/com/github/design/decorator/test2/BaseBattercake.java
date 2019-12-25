package com.github.design.decorator.test2;


/**
 * 功能描述:  基础煎饼套餐
 * @author: qinxuewu
 * @date: 2019/12/25 11:00
 * @since 1.0.0 
 */
public class BaseBattercake extends  Battercake {
    @Override
    protected String getName() {
        return "煎饼";
    }
    @Override
    protected int getPrice() {
        return 5;
    }
}
