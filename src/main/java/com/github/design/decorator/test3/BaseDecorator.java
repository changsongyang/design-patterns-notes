package com.github.design.decorator.test3;

//  基本装饰类
public  abstract  class BaseDecorator  implements IDecorator{

    private IDecorator decorator;

    public BaseDecorator(IDecorator decorator) {
        this.decorator = decorator;
    }

    /**
     * 调用装饰方法
     */
    @Override
    public void decorate() {
        if(decorator != null) {
            decorator.decorate();
        }
    }
}
