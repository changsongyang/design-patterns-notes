package com.github.jvm;

/**
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 *
 * @author qinxuewu
 * @create 20/2/6下午12:56
 * @since 1.0.0
 */


public class GcTest1 {

    public static void main(String[] args) {
        // 1M
        int size=1024 *1024;

        // 2M
        byte[] bytes1=new byte[2 * size];
        byte[] bytes2=new byte[2 * size];
        byte[] bytes3=new byte[2 * size];
        byte[] bytes4=new byte[2 * size];
        byte[] bytes5=new byte[6 * size];
        System.out.println("hello word");

    }
}
