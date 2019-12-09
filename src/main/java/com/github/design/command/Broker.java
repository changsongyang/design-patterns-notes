package com.github.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建命令调用类
 *
 * @author qinxuewu
 * @create 19/9/4下午7:43
 * @since 1.0.0
 */


public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
