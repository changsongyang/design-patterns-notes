package com.github.jvm;

/**
 * 方法的静态分配
 *
 * @author qinxuewu
 * @create 20/2/2下午3:17
 * @since 1.0.0
 */


public class MyTest5 {

    //方法重载，是一种静态行为，在编译期就可完全确定。
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }
    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        //  等号左边是静态类型 在编译器确定
        // 等号右边的是实际指向的类型
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
        // 以上两条语句执行结果为 grandpa

    }
}

class Grandpa {}
class Father extends Grandpa {}
class Son extends Grandpa {}