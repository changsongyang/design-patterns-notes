package com.github.juc.ThreadPoll;

import java.util.concurrent.*;

/**
 *  记录线程池中的堆栈信息
 *
 * @author qinxuewu
 * @create 20/2/1下午4:20
 * @since 1.0.0
 */


public class TraceThreadPollExecutor  extends ThreadPoolExecutor {

    public  TraceThreadPollExecutor(int corePoolSize, int maxmumPoolSize,
                                    long keepAliveTime, TimeUnit unit, BlockingQueue workQueue){
        super(corePoolSize,maxmumPoolSize,keepAliveTime,unit,workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(command);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(task);
    }

    private  Exception clientTrace(){
        return  new Exception("Client stack trace");
    }

    /**
     *  保存着提交任务的线程的堆栈信息。该方法将我们传入的Runnable任务进行一层包装，使之能处理异常信息。当任务发生异常时，这个异常会被打印
     * @param task
     * @param clientStack
     * @param clientThreadName
     * @return
     */
    private  Runnable wrap(final  Runnable task,final  Exception clientStack, String clientThreadName){
        return  new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                }catch (Exception e){
                    clientStack.printStackTrace();
                    throw  e;
                }
            }
        };
    }


    public static void main(String[] args) {
        ThreadPoolExecutor pools=new TraceThreadPollExecutor(0,Integer.MAX_VALUE,
                0L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        /**
         * 错误堆栈中可以看到是在哪里提交的任务
         */
        for (int i=0;i<5;i++){
            pools.execute(new DivTask(100,i) );
        }
    }

    public  static  class  DivTask implements  Runnable{
        int a,b;
        public  DivTask(int a,int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"  a="+a+",  b=="+b);
            double re=a/b;
            System.out.println(re);
        }
    }

}
