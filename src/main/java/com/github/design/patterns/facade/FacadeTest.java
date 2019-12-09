package com.github.design.patterns.facade;

public class FacadeTest {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.onCPU();
        facade.onDDR();
        facade.onSSD();
    }
}
