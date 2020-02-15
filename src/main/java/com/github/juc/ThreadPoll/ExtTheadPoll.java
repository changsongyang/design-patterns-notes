package com.github.juc.ThreadPoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor是一个可以扩展的线程池。它提供了beforeExecute()、afterExecute()和terminated()三个接口用来对线程池进行控制
 * beforeExecute() 运行前
 * afterExecute() 运行结束后
 * @author qinxuewu
 * @create 20/2/1下午4:06
 * @since 1.0.0
 */


public class ExtTheadPoll {

    public  static  class MyTask implements  Runnable{
        public  String name;
        public  MyTask(String name){
            this.name=name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" 正在细执行。。。"+" task Name="+name);
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es=new ThreadPoolExecutor(5,5,0L,TimeUnit.MILLISECONDS
                    ,new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
               System.out.println("准备执行 :"+((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成 :"+((MyTask) r).name);
            }

            @Override
            protected void terminated() {
               System.out.println("线程池退出");
            }
        };

        for (int i = 0; i <5 ; i++) {
            MyTask task=new MyTask("task-"+i);
            es.execute(task);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}
