package com.github.design.adapter.interfaceadapter;


/**
 * 功能描述:  创建一个SD卡的接口
 * @author: qinxuewu
 * @date: 2019/12/25 10:07
 * @since 1.0.0
 */
public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    int writeSD(String msg);
}
