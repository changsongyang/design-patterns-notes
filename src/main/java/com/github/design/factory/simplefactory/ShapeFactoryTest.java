package com.github.design.factory.simplefactory;

public class ShapeFactoryTest {

    public static void main(String[] args) {
        ShapeFactory factory=new ShapeFactory();

        Shape s1=factory.getShape(1);
        s1.drwa();

        Shape s2=factory.getShape(2);
        s2.drwa();
    }
}
