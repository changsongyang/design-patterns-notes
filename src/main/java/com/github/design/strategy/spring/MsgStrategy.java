package com.github.design.strategy.spring;


/**
 * 功能描述: 策略抽象类
 * @author: qinxuewu
 * @date: 2019/12/9 14:27
 * @since 1.0.0
 */
public  abstract class MsgStrategy {
    /**
     * 发送小程序订阅消息的策略方法
     * @param jsonStr
     */
     public abstract  boolean sendMsg(String jsonStr);
}
