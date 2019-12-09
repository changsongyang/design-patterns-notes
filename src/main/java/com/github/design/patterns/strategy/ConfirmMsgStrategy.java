package com.github.design.patterns.strategy;



/**
 * 功能描述:  支付确认消息策略
 * @author: qinxuewu
 * @date: 2019/12/9 11:22
 * @since 1.0.0
 */
public class ConfirmMsgStrategy implements  Strategy{

    @Override
    public boolean sendMsg(String name) {
        System.out.println("支付确认消息通知消息: "+name);
        return true;
    }
}
