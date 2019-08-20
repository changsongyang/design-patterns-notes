package com.github.single.single01;



/**
 * 饿汉式-单列模式 这种方式比较常用，但容易产生垃圾对象。
 *      优点：没有加锁，执行效率会提高。
 *      缺点：类加载时就初始化，浪费内存。
 *
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 3:49
 */
public class Single1 {
    private  Single1(){}
    private  static  Single1 single=new Single1();
    public static   Single1 getSingleton(){
        return  single;
    }
}
