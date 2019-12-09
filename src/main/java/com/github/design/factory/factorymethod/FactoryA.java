package com.github.design.factory.factorymethod;

/**
 * 工厂A类 - 生产A类产品
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 5:36
 */
public class FactoryA extends  Factory {

    @Override
    public Product Manufacture() {
        return new ProductA();
    }

}
