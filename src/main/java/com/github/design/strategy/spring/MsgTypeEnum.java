package com.github.design.strategy.spring;


/**
 * 功能描述: 消息类型
 * @author: qinxuewu
 * @date: 2019/12/9 14:37
 * @since 1.0.0
 */
public enum  MsgTypeEnum {

    PAYORDER(1, "支付订单消息"),
    CONFIRM(2, "确认订单消息");
    private int code;
    private String desc;

    MsgTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**根据value返回枚举类型,主要在switch中使用*/
    public static MsgTypeEnum getByCode(int code) {
        for (MsgTypeEnum orderTypeEnum : values()) {
            if (orderTypeEnum.getCode() == code) {
                return orderTypeEnum;
            }
        }
        return null;
    }
}
