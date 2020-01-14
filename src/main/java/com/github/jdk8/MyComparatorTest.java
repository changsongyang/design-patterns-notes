package com.github.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 自定义排序
 *
 * @author qinxuewu
 * @create 20/1/11下午6:19
 * @since 1.0.0
 */


public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao","hello","world","welcome");
        // 默认的排序
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("---------------------");

        // 使用lamble表达式 按照长度排序 升序 。 降序就反过来
        Collections.sort(list,(item1,item2) -> item1.length() - item2.length());
        list.forEach(System.out::println);
        System.out.println("---------------------");

        //  方法引用的方式 按照长度升序 然后反转 就是降序
         Collections.sort(list,Comparator.comparingInt(String::length).reversed());
//         Collections.sort(list,Comparator.comparingInt((String item) -> item.length()).reversed());
        list.forEach(System.out::println);
        System.out.println("---------------------");

        // 函数式接口提供的方法排序
        list.sort(Comparator.comparingInt(String::length).reversed());


        //按照长度  在按照ascii码
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        list.forEach(System.out::println);
        System.out.println("---------------------");


        /// thenComparing 返回另一个排序后的比较器   compareTo  按字典顺序比较两个字符串。
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing((item1,item2) -> item1.toLowerCase().compareTo(item2.toLowerCase())));

        list.forEach(System.out::println);
        System.out.println("------------55555555555---------");




    }
}
