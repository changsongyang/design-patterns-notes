package com.github.jdk8;

import com.github.jdk8.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");
        //  集合中的字符串通过map映射为长度 条件过滤长度为5的 输出第一个元素的长度
//         list.stream().mapToInt(item -> item.length()).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

        // 输出长度 和对应的字符串
        list.stream().mapToInt(item ->{
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

        System.out.println("-------------------------");

        List<String> list2 = Arrays.asList("hello welcome","world hello","hello world hello","hello welcome");
        // 输出的类的信息
//        list2.stream().map(itm -> itm.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println);


        List<String> list3 = Arrays.asList("hello welcome","world hello","hello world hello","hello welcome");
        // flatMap 将多个Stream连接成一个Stream  主要是用于stream合并，这个功能非常实用，他是默认实现多CPU并行执行的，所以我们合并集合优先实用这种方式。
        List<String> result = list3.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("-------------------------------------");
        List<String> list4 = Arrays.asList("hello welcome","world hello","hello world hello","hello welcome");
        List<String > result2 = list4.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        result2.forEach(System.out::println);

        System.out.println("-------------------------------------");

        List<String> list5 = Arrays.asList("hi","Hello","你好");
        List<String> list6 = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");

        // 多重集合遍历 把list5中每个字符串遍历一次的同时 把集合中的字符串也同时输出
        //  集合1的字符串多多个集合2的字符串
        list5.stream().flatMap(item ->list6.stream().map(item2 -> item+ " "+item2)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("-------------------------------------");

        // 流分组

        Student student1 = new Student("zhangsan",100);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("wangwu",90);
        Student student4 = new Student("zhangsan",80);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);
        // 名字分组
//        Map<String,List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        // 年龄分组
//        Map<Integer,List<Student>> map2 = students.stream().collect(Collectors.groupingBy(Student::getAge));

        // 分区
        Map<Boolean,List<Student>> map = students.stream().collect(Collectors.partitioningBy(student ->student.getAge() >= 90));
        System.out.println(map);
    }
}
