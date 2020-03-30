package com.github.juc.Condition;


import java.util.Vector;

/**
 * 功能描述: 通过wait() / notify()来实现一个简单的生产者和消费者
 * @author: qinxuewu
 * @date: 2020/3/27 15:45
 * @since 1.0.0
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        Vector<Integer> pool=new Vector<Integer>();
        Producer producer=new Producer(pool, 10);
        Consumer consumer=new Consumer(pool);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


/**
 * 生产者
 */
class  Producer implements  Runnable{
    private Vector<Integer> pool;
    private  Integer size;

    public Producer(Vector<Integer> pool,Integer size) {
        this.pool=pool;
        this.size=size;
    }

    @Override
    public void run() {
        for (;;){
            try {
                System.out.println("生产一个商品");
                produce(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private  void  produce(int i) throws InterruptedException {
        while (pool.size()==size){
            //队列已满  进入等待模式 等待消费者消费
            synchronized (pool){
                System.out.println("生产者等待消费者消费商品,当前商品数量为"+pool.size());
                pool.wait();
            }
        }

        // 队列未满 继续生产
        synchronized (pool){
            pool.add(i);
            //生产成功，通知消费者消费
            pool.notifyAll();
        }
    }
}


class  Consumer implements  Runnable{
    private  Vector<Integer>  pool;
    public  Consumer(Vector<Integer>  pool){
        this.pool=pool;
    }
    @Override
    public void run() {
        for (;;){
            try {
                System.out.println("消费一个商品");
                consume();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        while (pool.isEmpty()){
            // 队列为空 则等待生产者生产消息
            synchronized (pool){
                System.out.println("消费者等待生产者生产商品,当前商品数量为"+pool.size());
                pool.wait();//等待生产者生产商品
            }
        }
        synchronized (pool){
            pool.remove(0);
            //通知生产者生产商品
            pool.notifyAll();
        }

    }


}