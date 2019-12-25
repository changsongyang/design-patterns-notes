package com.github.design.adapter.interfaceadapter;


/**
 * 功能描述: 创建一个计算机实例，实现计算机接口，并实现其读取SD卡方法：
 * @author: qinxuewu
 * @date: 2019/12/25 10:09
 * @since 1.0.0 
 */
public class ThinkpadComputer implements  Computer {
    @Override
    public String readSD(SDCard sdCard) {
        return sdCard.readSD();
    }


}
