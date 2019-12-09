package com.github.design.patterns.command;

/**
 * 〈〉
 *
 * @author qinxuewu
 * @create 19/9/4下午7:42
 * @since 1.0.0
 */


public class SellStock implements  Order {
    private  Stock abcStock;
    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }

}
