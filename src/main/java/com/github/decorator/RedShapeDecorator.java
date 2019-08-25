package com.github.decorator;

// 创建扩展了 ShapeDecorator 类的实体装饰类

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        // 绘图
        decoratedShape.draw();
        // 设置边框颜色
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("设置边框颜色：红色");
    }
}