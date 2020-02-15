package com.github.jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * Java字节码对于异常的处理方式：
    1. 统一采用异常表的方式来对异常进行处理。
    2. 在JDK1.4.2之前，并不是采用异常表，而是采用特定指令。
    3. 当异常处理存在finally语句块时，现在JVM采用将finally语句的字节码拼接到每一个语句块的后面的处理方式。
    换句话说，程序中存在多少个catch块，就会重复多少次finally语句块。
 *
 * @author qinxuewu
 * @create 20/2/1下午1:50
 * @since 1.0.0
 */


public class MyTest3 {

    public void test() throws IOException, FileNotFoundException {
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }

}
/***
 *  new #2 <java/io/FileInputStream>  创建一个实例
 *  3 dup  压如虚拟机栈顶中
 *  4 ldc #3 <test.txt>  从常量池加载一个字符串
 *  6 invokespecial #4 <java/io/FileInputStream.<init>>  初始化InputStream父类的构造方法
 *  9 astore_1
 * 10 new #5 <java/net/ServerSocket>
 * 13 dup
 * 14 sipush 9999 push一个shror值
 * 17 invokespecial #6 <java/net/ServerSocket.<init>>
 * 20 astore_2
 * 21 aload_2
 * 22 invokevirtual #7 <java/net/ServerSocket.accept> 初始父类
 * 25 pop                                   t弹出操作数栈 栈顶的值
 * 26 getstatic #8 <java/lang/System.out>
 * 29 ldc #9 <finally>
 * 31 invokevirtual #10 <java/io/PrintStream.println>
 * 34 goto 84 (+50)
 * 37 astore_1
 * 38 getstatic #8 <java/lang/System.out>
 * 41 ldc #9 <finally>
 * 43 invokevirtual #10 <java/io/PrintStream.println>
 * 46 goto 84 (+38)
 * 49 astore_1
 * 50 getstatic #8 <java/lang/System.out>
 * 53 ldc #9 <finally>
 * 55 invokevirtual #10 <java/io/PrintStream.println>
 * 58 goto 84 (+26)
 * 61 astore_1
 * 62 getstatic #8 <java/lang/System.out>
 * 65 ldc #9 <finally>
 * 67 invokevirtual #10 <java/io/PrintStream.println>
 * 70 goto 84 (+14)
 * 73 astore_3
 * 74 getstatic #8 <java/lang/System.out>
 * 77 ldc #9 <finally>
 * 79 invokevirtual #10 <java/io/PrintStream.println>
 * 82 aload_3
 * 83 athrow
 * 84 return
 */

