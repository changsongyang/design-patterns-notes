package com.github.design.strategy;


/**
 * 功能描述:  订单服务通知消息策略
 * @author: qinxuewu
 * @date: 2019/12/9 11:21
 * @since 1.0.0
 */
public class OrderMsgStrategy implements Strategy {
    @Override
    public boolean sendMsg(String name) {
        System.out.println("发送订单服务通知消息: "+name);
        return true;
    }
}
