package com.github.design.strategy.spring;

import java.util.Map;

/**
 * 功能描述:  策略的上下文
 * @author: qinxuewu
 * @date: 2019/12/9 14:51
 * @since 1.0.0
 */

public class StrategyContext {
    private Map<MsgTypeEnum, Class> strategyMap;

    public StrategyContext(Map<MsgTypeEnum, Class> strategyMap) {
        this.strategyMap = strategyMap;
    }
    public  Map<MsgTypeEnum, Class> getStrategyMap() {
      return  strategyMap;
    }


    public MsgStrategy getStrategy(MsgTypeEnum orderTypeEnum)  {
        try {

            Class clazz = strategyMap.get(orderTypeEnum);
            if (clazz == null) {
                throw new IllegalArgumentException("not fond strategy for type:" + orderTypeEnum.getCode());
            }
            return (MsgStrategy)  SpringBeanUtils.getBean(clazz);

        }catch (Exception e){
            e.printStackTrace();
        }
          return  null;

    }
}
