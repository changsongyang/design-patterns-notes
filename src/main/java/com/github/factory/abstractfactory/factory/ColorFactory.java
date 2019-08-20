package com.github.factory.abstractfactory.factory;
import com.github.factory.abstractfactory.Green;
import com.github.factory.abstractfactory.Red;
import com.github.factory.abstractfactory.interfaces.Color;
import com.github.factory.abstractfactory.interfaces.Shape;

/**
 *  创建扩展了 AbstractFactory 的颜色的工厂类
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 上午 11:51
 */
public class ColorFactory extends AbstractFactory {

    /**
     * 获取颜色的对象
     * @param color
     * @return
     */
    @Override
    public Color getColor(String color) {
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;
    }

    // 获取绘制图形的对象

    @Override
    public Shape getShape(String shape) {

        return null;
    }
}
