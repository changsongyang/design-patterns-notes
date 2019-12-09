package com.github.design.factory.factorymethod;

/**
 *  创建具体产品类（继承抽象产品类）， 定义生产的具体产品
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 5:29
 */
public class ProductA  extends  Product{

    @Override
    public void Show() {
        System.out.println("制造产品A.........");
    }
}
