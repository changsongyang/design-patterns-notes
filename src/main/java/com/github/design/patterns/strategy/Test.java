package com.github.design.patterns.strategy;


/**
 * 功能描述:  策略模式测试
 * @author: qinxuewu
 * @date: 2019/12/9 11:53
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        String msgKey="order";
        StrategyContext context=new StrategyContext(MsgStrategyFactory.getStrategy(msgKey));
        context.execute("aaaa");

    }
}
