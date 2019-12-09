package com.github.design.factory.abstractfactory;

import com.github.design.factory.abstractfactory.interfaces.Shape;

/**
 * 圆形
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 上午 11:35
 */
public class Circle  implements Shape {


    public void draw() {
        System.out.println("绘制圆形......");
    }
}
