package com.github.design.strategy;


/**
 * 功能描述: 策略模式的上下文  执行策略的方法
 * @author: qinxuewu
 * @date: 2019/12/9 11:54
 * @since 1.0.0
 */
public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy=strategy;
    }

    public  boolean execute(String name){
        return  strategy.sendMsg(name);
    }
}
