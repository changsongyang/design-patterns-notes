package com.github.design.patterns.adapter.objectadapter;

public class Phone {


    public  void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5v()==5){
            System.out.println("电压5v， 可以充电---");
        }else if(iVoltage5V.output5v()>5){
            System.out.println("电压大于 5V, 不能充电~~");
        }
    }
}
