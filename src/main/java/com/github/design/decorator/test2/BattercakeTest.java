package com.github.design.decorator.test2;

public class BattercakeTest {

    public static void main(String[] args) {
        Battercake battercake;
        //路边摊买一个煎饼
        battercake = new BaseBattercake();
        //煎饼有点小， 想再加一个鸡蛋
        battercake = new EggDecorator(battercake);
        //再加一个鸡蛋
        battercake = new EggDecorator(battercake);
        //很饿， 再加根香肠
        battercake = new SausageDecorator(battercake);
        // 装饰器更多考虑是扩展
        System.out.println(battercake.getName() + ",总价： " + battercake.getPrice());
    }
}
