package com.github.factory.abstractfactory.factory;
import com.github.factory.abstractfactory.Circle;
import com.github.factory.abstractfactory.Rectangle;
import com.github.factory.abstractfactory.Square;
import com.github.factory.abstractfactory.interfaces.Color;
import com.github.factory.abstractfactory.interfaces.Shape;

/**
 *  创建扩展了 AbstractFactory 的图形的工厂类
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 上午 11:51
 */
public class ShapeFactory  extends AbstractFactory {

    /**
     * 获取颜色的对象
     * @param color
     * @return
     */
    @Override
    public Color getColor(String color) {

        return null;
    }

    // 获取绘制图形的对象

    @Override
    public Shape getShape(String shape) {
        if(shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shape.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
