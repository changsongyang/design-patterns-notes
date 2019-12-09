package com.github.design.bridge;

public class Vivo  implements  Brand{
    public void open() {
        System.out.println(" Vivo 手机开机 ");
    }

    public void close() {
        System.out.println(" Vivo 手机关机 ");
    }

    public void call() {
        System.out.println(" Vivo 手机打电话 ");
    }
}
