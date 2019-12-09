package com.github.design.patterns.factory.abstractfactory;

import com.github.design.patterns.factory.abstractfactory.interfaces.Color;

/**
 * 红色
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 上午 11:40
 */
public class Red implements Color {

    public void fill() {
        System.out.println("红色...........");
    }
}
