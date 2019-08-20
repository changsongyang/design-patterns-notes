package com.github.factory.abstractfactory;
import com.github.factory.abstractfactory.factory.AbstractFactory;
import com.github.factory.abstractfactory.factory.FactoryProducer;
import com.github.factory.abstractfactory.interfaces.Color;
import com.github.factory.abstractfactory.interfaces.Shape;

public class AbstractFactoryPatternTest {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();



        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("RED");
        color1.fill();

        Color color2=colorFactory.getColor("GREEN");
        color2.fill();
    }
}
