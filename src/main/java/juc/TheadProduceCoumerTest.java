package juc;




import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 功能描述: 多线程 生产者消费者模式
 * @author: qinxuewu
 * @date: 2019/11/22 9:07
 * @since 1.0.0
 */
public class TheadProduceCoumerTest {
    static BlockingQueue<String> queue=new LinkedBlockingQueue<>(2000);
    public static void main(String[] args) throws InterruptedException {
        start();
        for (int i = 0; i <10000 ; i++) {
            queue.add(Thread.currentThread().getName()+"执行。"+i);
            Thread.sleep(1000);
        }

    }

    // 启动5个消费者线程 批量执行任务
  public  static   void  start(){
        ExecutorService ex= Executors.newFixedThreadPool(5);
        for (int i = 0; i <5 ; i++) {
            ex.execute(()->{
                    try {
                        while (true){
                            // 批量获取任务
                            List<String> list=pollTaks();
                            // 批量执行任务
                            execTaks(list);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            });
        }
    }

    // 从任务队列中批量获取任务
    public  static List<String> pollTaks() throws InterruptedException {
            List<String> list=new ArrayList<>();
            // 阻塞式获取一条任务
             String t=queue.take();
            while (t!=null){
                list.add(t);
                // 非阻塞式获取一条任务
                t=queue.poll();
            }
            return  list;
    }
    // 批量执行任务
    public  static void execTaks(List<String> list){
            for(String s:list){
                System.out.println(s);
            }
    }
}
