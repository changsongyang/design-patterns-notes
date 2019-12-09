package com.github.juc;

public class Test {

    public static void main(String[] args) {
        // 下面代码会内存溢出吗  jvm参数：-Xmx10m -Xms10m
        // 每次循环只是操作局部变量表，替换之前的引用对象  栈帧还是一个
        while (true){
            byte[] bytes=new byte[1024];
            test2();
        }
    }

    public  static  void  test2(){
        System.out.println("ssss");
    }
}
