package com.github.design.strategy.spring;
import org.springframework.stereotype.Service;

/**
 * 功能描述:  支付确认消息策略
 * @author: qinxuewu
 * @date: 2019/12/9 11:22
 * @since 1.0.0
 */
@Service
@MsgTypeAnnotation(msgType = MsgTypeEnum.CONFIRM)
public class ConfirmMsgStrategy extends MsgStrategy {

    @Override
    public boolean sendMsg(String jsonStr) {
        // 具体业务处理
        System.out.println("发送支付确认消息通知策略： "+jsonStr);
        return true;
    }
}
