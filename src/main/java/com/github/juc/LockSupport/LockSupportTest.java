package com.github.juc.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程阻塞工具类：LockSupport
 *  1.不需要先获得某个对象的锁
 *  2.不会抛出InterruptedException异常
 *  3. LockSupport 的静态方法 park()可以阻塞当前线程，
 *      类似的还有 parkNanos()、parkUntil() 等方法。它们实现了一个限时的等待
 *
 * @author qinxuewu
 * @create 20/2/1下午2:33
 * @since 1.0.0
 */


public class LockSupportTest {
    public  static  Object u=new Object();
    static  ChangeObjectThead t1=new ChangeObjectThead("t1");
    static  ChangeObjectThead t2=new ChangeObjectThead("t2");

    public  static  class ChangeObjectThead extends  Thread{
        public  ChangeObjectThead(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in "+getName());
                //  申请一个许可，如果许可可用，那么park()方法会立即返回,并且消费这个许可
                LockSupport.park();  // 阻塞
                System.out.println(getName()+" 开始阻塞。。。。。");
                if(Thread.interrupted()){
                    System.out.println(getName()+"被中断 了。。。。。。。。");
                }
                System.out.println(getName()+" 执行结束......");
            }
        }
    }

    /***
     * LockSupport类使用类似信号量的机制。它为每一个线程准备了一个许可，如果许可可用，那么park()方法会立即返回，并且消费这个许可（也就是将许可变为不可用），
     * 如果许可不可用，就会阻塞，而unpark()方法则使得一个许可变为可用（但是和信号量不同的是，许可不能累加，你不可能拥有超过一个许可，它永远只有一个）
     */

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        // 即使unpark()方法操作发生在park()方法之前，它也可以使下一次的park()方法操作立即返回
//        LockSupport.unpark(t1);
        LockSupport.unpark(t2);

        // main线程等待t1,t2执行完毕
        t1.join();
        t2.join();

        System.out.println("main........");
    }
}
