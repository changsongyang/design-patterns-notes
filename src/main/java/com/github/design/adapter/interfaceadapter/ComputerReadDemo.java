package com.github.design.adapter.interfaceadapter;

public class ComputerReadDemo {

    public static void main(String[] args) {
        Computer computer=new ThinkpadComputer();
        SDCard sdCard = new SDCardImpl();
        //  模拟计算机读取SD卡功能
        System.out.println(computer.readSD(sdCard));


        // 不改变计算机读取SD卡接口的情况下，通过适配器模式读取TF卡
        TFCard tfCard = new TFCardImpl();
        SDCard tfCardAdapterSD = new SDAdapterTF(tfCard);
        System.out.println(computer.readSD(tfCardAdapterSD));
    }
}
