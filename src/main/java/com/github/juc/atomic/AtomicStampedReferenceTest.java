package com.github.juc.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带有时间戳的对象引用
 *
 * @author qinxuewu
 * @create 20/2/1下午8:14
 * @since 1.0.0
 */


public class AtomicStampedReferenceTest {
    private static AtomicStampedReference<Integer> money=new AtomicStampedReference<>(19,0);

    public static void main(String[] args) {
        // 模拟多个线程同时更新后台数据 为用户充值

        for (int i = 0; i < 3; i++) {
            final  int timestamp=money.getStamp();
            new Thread(()->{
                while (true){
                    while (true){
                        Integer m=money.getReference();
                        if(m<20){
                            if(money.compareAndSet(m,m+20,timestamp,timestamp+1)){
                                System.out.println("余额小于20 充值成功  余额："+money.getReference());
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }).start();
        }

        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                while (true){
                    int temestamp=money.getStamp();
                    Integer m=money.getReference();
                    if(m>10){
                        System.out.println("大于10元");
                        if(money.compareAndSet(m,m-10,temestamp,temestamp+1)){
                            System.out.println("成功消息10元 余额："+money.getReference());
                            break;
                        }
                    }else {
                        System.out.println("没有足够金额消费。。。。");
                        break;
                    }
                }
                try {
                    Thread.sleep(100);
                }catch (Exception e){}
            }
        }).start();
    }

}
