package com.github.design.factory.factorymethod;

public class FactoryTest {
    public static void main(String[] args) {

        // 通过调用具体工厂类的方法，从而创建不同具体产品类的实例
        FactoryA  factoryA=new FactoryA();
        factoryA.Manufacture().Show();

        FactoryB factoryB=new FactoryB();
        factoryB.Manufacture().Show();

    }
}
