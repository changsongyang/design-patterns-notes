package com.github.design.patterns.facade;

/** * 硬盘类 */
class Ssd implements Computer {

    public void open() {
        System.out.println("启动硬盘");
    }
}