package com.github.juc.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈〉
 *
 * @author qinxuewu
 * @create 20/1/31下午10:03
 * @since 1.0.0
 */


public class ReenteLockConditon  implements  Runnable{
    public   static ReentrantLock lock=new ReentrantLock();
    public  static Condition condition=lock.newCondition();
    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("in.............");
            condition.await();
            System.out.println("thread is going on");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenteLockConditon t1=new ReenteLockConditon();
        Thread  t=new Thread(t1);
        t.start();

        //  停顿一下 然t1线程先执行 不然会出现通知t1 无效  先执行singal()
        Thread.sleep(1000);

        // 通知t1 线程继续执行
        lock.lock();
        System.out.println("main..........start");
        condition.signal();
        lock.unlock();
        System.out.println("main...........end");
    }
}
