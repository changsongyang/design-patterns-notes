package com.github.design.adapter.interfaceadapter;


/**
 * 功能描述:  创建SD适配TF （也可以说是SD兼容TF，相当于读卡器）
 *          不改变计算机读取SD卡接口的情况下，通过适配器模式读取TF卡
 *
 * @author: qinxuewu
 * @date: 2019/12/25 10:13
 * @since 1.0.0
 */
public class SDAdapterTF  implements  SDCard{
    private TFCard tfCard;
    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }
    @Override
    public String readSD() {
        return tfCard.readTF();
    }
    @Override
    public int writeSD(String msg) {
        return tfCard.writeTF(msg);
    }
}
