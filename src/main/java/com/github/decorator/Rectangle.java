package com.github.decorator;

// 创建实现接口的实体类。 长方形
public class Rectangle implements Shape {


    public void draw() {
        System.out.println("绘图: 长方形 ");
    }
}