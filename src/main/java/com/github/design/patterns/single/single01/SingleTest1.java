package com.github.design.patterns.single.single01;

/**
 * 饿汉式-单列模式 这种方式比较常用，但容易产生垃圾对象。
 *      优点：没有加锁，执行效率会提高。
 *      缺点：类加载时就初始化，浪费内存。
 *
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 3:49
 */
public class SingleTest1 {

    public static void main(String[] args) {
        Single1 s1= Single1.getSingleton();
        Single1 s2= Single1.getSingleton();
    }



}


