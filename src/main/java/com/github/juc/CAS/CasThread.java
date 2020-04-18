package com.github.juc.CAS;

import org.apache.commons.lang3.time.StopWatch;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现CAS原语
 *  Java里面有AtomicInteger等等封装好的类，包含了CAS和FAA等原子操作，可以直接使用的。
 *
 * @author qinxuewu
 * @create 20/4/18上午10:08
 * @since 1.0.0
 */


public class CasThread  implements  Runnable{

    private AtomicInteger total;
    private CountDownLatch latch;

    public  CasThread(AtomicInteger total,CountDownLatch latch){
        this.total=total;
        this.latch=latch;
    }

    @Override
    public void run() {
        while (!total.compareAndSet(total.get(), total.get() + 1)){}
        latch.countDown();
    }


    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(1000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1000, 2000, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 1000; i ++) {
            executor.execute(new CasThread(atomicInteger, latch));
        }
        latch.await();
        System.out.println(atomicInteger.get());
        System.out.println("消耗：" + stopWatch.getTime() + "ms");

    }
}
