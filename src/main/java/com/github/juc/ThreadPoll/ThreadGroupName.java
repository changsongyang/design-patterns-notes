package com.github.juc.ThreadPoll;


/**
 * 功能描述:  线程组
 * @author: qinxuewu
 * @date: 2019/12/23 15:16
 * @since 1.0.0
 */
public class ThreadGroupName implements  Runnable {

    public static void main(String[] args) {
        // 线程组
        ThreadGroup group=new ThreadGroup("testGroup");

        Thread t1=new Thread(group,new ThreadGroupName(),"t1");
        Thread t2=new Thread(group,new ThreadGroupName(),"t2");

        t1.start();
        t2.start();
        System.out.println(group.activeCount());
        group.list();
    }

    @Override
    public void run() {
        String  groupName=Thread.currentThread().getThreadGroup().getName()+"_"+Thread.currentThread().getName();

        while (true){
            System.out.println(" 线程组名："+groupName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
