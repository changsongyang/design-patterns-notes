package com.github.design.patterns.factory.abstractfactory.factory;

import com.github.design.patterns.factory.abstractfactory.interfaces.Color;
import com.github.design.patterns.factory.abstractfactory.interfaces.Shape;

/**
 *
 * 为 Color 和 Shape 对象创建抽象类来获取工厂
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 上午 11:50
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
