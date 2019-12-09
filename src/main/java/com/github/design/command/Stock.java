package com.github.design.command;

/**
 * 创建一个请求类
 *
 * @author qinxuewu
 * @create 19/9/4下午7:26
 * @since 1.0.0
 */


public class Stock {

    private  String name="abc";
    private  int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
