package com.github.design.adapter.interfaceadapter;


/**
 * 功能描述: SD卡的实现类
 * @author: qinxuewu
 * @date: 2019/12/25 10:07
 * @since 1.0.0
 */
public class SDCardImpl implements  SDCard {
    @Override
    public String readSD() {
        return "读取SDK";
    }
    @Override
    public int writeSD(String msg) {
        System.out.println("写入SD卡 : " + msg);
        return 1;
    }
}
