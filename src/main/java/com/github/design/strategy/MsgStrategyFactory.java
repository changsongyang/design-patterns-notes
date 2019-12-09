package com.github.design.strategy;


import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:  服务通策略工厂
 * @author: qinxuewu
 * @date: 2019/12/9 11:42
 * @since 1.0.0 
 */
public class MsgStrategyFactory {
    private  static Map<MsgTypeEnum, Strategy> STRATEGY_MAP=new HashMap<>();
    //  初始化不同的消息类型key  此处可以结合Spring扫描注解自动注入
    static {
        STRATEGY_MAP.put(MsgTypeEnum.PAYORDER,new OrderMsgStrategy());
        STRATEGY_MAP.put(MsgTypeEnum.CONFIRM,new ConfirmMsgStrategy());
    }

    private  MsgStrategyFactory(){}

    /**
     *  忽略key为空的情况
     * @param msgKey
     * @return
     */
    public  static Strategy getStrategy(int msgKey){
       return  STRATEGY_MAP.get(MsgTypeEnum.getByCode(msgKey));
    }


}


