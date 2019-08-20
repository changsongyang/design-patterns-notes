package com.github.factory.abstractfactory;


import com.github.factory.abstractfactory.interfaces.Shape;

/**
 *  长方形  创建实现接口的实体类
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 4:56
 */
public class Rectangle  implements Shape {

    public void draw() {
        System.out.println("绘制长方行........");
    }

}
