package juc;


/**
 * 功能描述: 
 * @author: qinxuewu
 * @date: 2019/11/18 15:02
 * @since 1.0.0 
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;




    public void  writer(){
        // 当第一个操作为普通变量的读/写时，如果第二个操作是volatile写，则编译器不能重排序这个两个操作
        x=42;
        v=true;
    }

    public  void  read(){
        // 当一个操作是volatile写时，第二个操作时volatile读时，不能重排序
        if(v==true){
            // 这里x会是多少
            // 这个要看 Java 的版本，如果在低于 1.5 版本上运行，x 可能是 42，也有可能是 0；变量 x可能被 CPU 缓存而导致可见性问题
            // 如果在 1.5 以上的版本上运行，x 就是等于 42。 Java 内存模型在 1.5 版本对 volatile 语义进行了增强 前面一个操作的结果对后续操作是可见的
            System.out.println("x="+x);
        }
    }

    public static void main(String[] args) {
        final VolatileExample example=new VolatileExample();
        new Thread(new Runnable() {
            @Override
            public void run() {
                example.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                example.read();
            }
        }).start();
    }
}
