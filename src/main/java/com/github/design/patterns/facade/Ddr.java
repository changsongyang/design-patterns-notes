package com.github.design.patterns.facade;


/** * 内存类 */
class Ddr implements Computer {
    public void open() {
        System.out.println("启动内存");
    }
}