package com.github.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        Executor executor= Executors.newFixedThreadPool(2);

        while (true){
            CountDownLatch countDownLatch=new CountDownLatch(2);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("查询未对账订单.....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 计数器减1
                    countDownLatch.countDown();
                }
            });

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("查询派送订单.....");
                    // 计数器减1
                    countDownLatch.countDown();
                }
            });
            // 等待查询结果
            countDownLatch.await();
            System.out.println("执行对账操作 差异写入库...........");
        }
    }
}
