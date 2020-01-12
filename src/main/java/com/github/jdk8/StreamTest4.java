package com.github.jdk8;

import com.github.jdk8.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import static java.util.stream.Collectors.*;
/**
 * 〈〉
 *
 * @author qinxuewu
 * @create 20/1/11下午6:35
 * @since 1.0.0
 */


public class StreamTest4 {


    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",80);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("wangwu",100);
        Student student4 = new Student("zhaoliu",90);
        Student student5 = new Student("zhaoliu",80);

        List<Student> students =Arrays.asList(student1,student2,student3,student4,student5);

        System.out.println("count:"+students.stream().count());

        // 按照年龄排序 取出年龄最小的u元素
        students.stream().collect(minBy(Comparator.comparingInt(Student::getAge))).ifPresent(System.out::println);
        // 取最大年龄的元素
        students.stream().collect(maxBy(Comparator.comparingInt(Student::getAge))).ifPresent(System.out::println);

        // 计算平均年龄
        System.out.println(students.stream().collect(averagingInt(Student::getAge)));
        // 计算年龄总和
        System.out.println(students.stream().mapToInt(Student::getAge).sum());
        System.out.println(students.stream().collect(summingInt(Student::getAge)));


        // 一个状态对象，用于收集统计信息，例如计数，最小值，最大值，总和，平均。
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(summarizingInt(Student::getAge));
        System.out.println(intSummaryStatistics);
        System.out.println(students.stream().map(Student::getName).collect(joining()));
        System.out.println(students.stream().map(Student::getName).collect(joining(",")));
        System.out.println(students.stream().map(Student::getName).collect(joining(",","<begen>","<end>")));



        System.out.println("分组。。。。。。。。。。。。。");

        Map<Integer, Map<String, List<Student>>> map = students.stream().collect(groupingBy(Student::getAge,groupingBy(Student::getName)));

        System.out.println(map);


        System.out.println("分区..............");
        Map<Boolean,List<Student>> map2 = students.stream().collect(partitioningBy(student -> student.getAge()>80));
        System.out.println(map2);

    }
}
