package com.github.design.patterns.factory.abstractfactory;


import com.github.design.patterns.factory.abstractfactory.interfaces.Shape;

/**
 *  正方形
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 4:57
 */
public class Square  implements Shape {

    public void draw() {
        System.out.println("绘制正方形......");
    }
}
