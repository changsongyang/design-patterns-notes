package com.github.adapter.classadapter;

// 适配器
public class VoltageAdapter extends  Voltage220V implements  IVoltage5V {

    public int output5v() {
        //获取到 220V 电压
        int srcV = output220V();
        int dstV=srcV/44;//转成 5v
        return dstV;
    }
}
