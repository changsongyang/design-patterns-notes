package com.github.juc;

public class SynchronizedExample {

    // 修饰非静态方法, 锁定的是当前实例对象 this
    synchronized void foo() {
        // 临界区
    }
    // 修饰静态方法
    // 当修饰静态方法的时候，锁定的是当前类的 Class(SynchronizedExample.class) 对象
    synchronized static void bar() {
        // 临界区
    }

    Object obj = new Object();
    void baz() {
        // 同步方法块，锁是括号里面的对象。同步代码块是使用monitorenter和monitorexit指令实现的.
        synchronized(obj) {
                // 临界区
        }
    }
}
