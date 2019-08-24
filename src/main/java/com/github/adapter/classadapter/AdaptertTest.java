package com.github.adapter.classadapter;

public class AdaptertTest {

    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.charging(new VoltageAdapter());
    }
}
