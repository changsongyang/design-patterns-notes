package com.github.design.patterns.command;

/**
 * 创建实现了 Order 接口的实体类
 *
 * @author qinxuewu
 * @create 19/9/4下午7:41
 * @since 1.0.0
 */


public class BuyStock implements  Order{

    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
