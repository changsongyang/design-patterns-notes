package com.github.factory.simplefactory;

/**
 * 创建一个工厂，生成基于给定信息的实体类的对象
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 4:58
 */
public class ShapeFactory {

    // 根据类型获取对应形状的对象
    public  Shape getShape(int type){

        if (type==1){
            return  new Rectangle();
        }else if (type==2){
            return  new Square();
        }else {
            return  null;
        }
    }
}
