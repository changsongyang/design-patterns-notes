package com.github.design.strategy.spring;

import org.springframework.stereotype.Service;

/**
 * 功能描述:  订单服务通知消息策略
 * @author: qinxuewu
 * @date: 2019/12/9 11:21
 * @since 1.0.0
 */
@Service
@MsgTypeAnnotation(msgType = MsgTypeEnum.PAYORDER)
public class OrderMsgStrategy implements MsgStrategy {

    @Override
    public boolean sendMsg(String jsonStr) {
        // 具体业务处理
        System.out.println("发送订单服务通知策略： "+jsonStr);
        return true;
    }
}
