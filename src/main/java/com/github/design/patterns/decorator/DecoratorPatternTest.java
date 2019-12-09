package com.github.design.patterns.decorator;

public class DecoratorPatternTest {
    public static void main(String[] args) {

        // 圆
        Shape circle = new Circle();

        // 象装饰类
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("圆形默认边框绘图开始。。。 ");
        circle.draw();

        System.out.println("圆形红色边绘图开始。。。");
        redCircle.draw();


        System.out.println("长方形红色边框绘图。。。。");
        redRectangle.draw();
    }
}
