package com.github.design.strategy.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Autowired
    private StrategyContext context;

    /**
     * 处理取消逻辑
     */
    @Test
    public void process() {
        String jsonStr="测试";
        MsgTypeEnum orderTypeEnum = MsgTypeEnum.getByCode(1);
        MsgStrategy strategy = context.getStrategy(orderTypeEnum);
        strategy.sendMsg(jsonStr);
    }
}
