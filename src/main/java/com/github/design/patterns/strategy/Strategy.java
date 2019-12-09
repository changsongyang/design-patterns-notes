package com.github.design.patterns.strategy;


/**
 * 功能描述: 使用策略模式-发送消息策略接口
 * @author: qinxuewu
 * @date: 2019/12/9 11:17
 * @since 1.0.0 
 */
public interface Strategy {

    /**
     * 发送消息的接口
     * @param name
     * @return
     */
    boolean sendMsg(String name);
}
