package com.github.design.adapter.interfaceadapter;


/**
 * 功能描述: 创建TF卡接口：
 * @author: qinxuewu
 * @date: 2019/12/25 10:11
 * @since 1.0.0 
 */
public interface TFCard {
    String readTF();
    int writeTF(String msg);
}
