package com.github.design.esponsibilitychain;

/**
 * 责任链模式 请求类
 *
 * @author qinxuewu
 * @create 19/12/16下午8:46
 * @since 1.0.0
 */


public class Request {

    private  int type=0;        //请求类型
    private  float price=0.0f;  // 请求金额
    private  int id=0;


    public  Request(int type,float price,int id){
        this.type=type;
        this.price=price;
        this.id=id;
    }

    public  int getType(){
        return  type;
    }

    public  float getPrice(){
        return  price;
    }

    public  int getId(){
        return  id;
    }

}
