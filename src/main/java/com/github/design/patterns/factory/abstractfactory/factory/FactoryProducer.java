package com.github.design.patterns.factory.abstractfactory.factory;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 上午 11:57
 */
public class FactoryProducer {

    public  static  AbstractFactory getFactory(String type){
        if(type.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(type.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }

}
