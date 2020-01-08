package com.github.jdk8;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) {
        System.out.println("随机生成一个流...........");
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        // 返回第一个元素
        stream.findFirst().ifPresent(System.out::println);



        // 返回一个有序的流，元素类型为整数  默认值为1开始  item+2=每次在原有数字+2 ,limit(6)=生产6个元素截止
        // 生成  1,3,5,7,9,11
        Stream<Integer> stream2 = Stream.iterate(1,item->item+2).limit(6);
//        stream2.distinct();   // 去重操作
        System.out.println("-----------------------------");
        /**
         * 条件过滤 获取大于2的元素
         * mapToInt 返回的结果必须是int类型 和map的区别就是指定了返回结果类型
         *  把流中的每个元素乘以2  并跳过前面两个元素，然后取前两个元素 最后求和。
         */
        System.out.println(stream2.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());

        // 流用完就关闭了 不能重复使用  。 返回此流的最小元素
//        stream2.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);

        System.out.println("-----------------------------");
        Stream<Integer> stream3 = Stream.iterate(1,item->item+2).limit(6);
        // 返回一个 IntSummaryStatistics描述有关此流的元素的各种数据 求和 运算等等
        IntSummaryStatistics summaryStatistics = stream3.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());


        System.out.println("-----------------------------");
        List<String> list = Arrays.asList("hellol", "world", "hello world");
        // 把集合中字符串的首字母变大写
        list.stream().map(item -> item.substring(0,1).toUpperCase()+item.substring(1)).forEach(System.out::println);


        System.out.println("-------------1----------------");
        // 此方法会阻塞 因为生成的随机流是010101 这种 然后跟了一个去重操作, 所以一直在去重操作
        // 所以后面的limit操作 就执行不了
//        IntStream.iterate(0,i->(i+1) % 2).distinct().limit(6).forEach(System.out::println);
        System.out.println("-------------2----------------");
        IntStream.iterate(0, i->(i+1) % 2).limit(6).distinct().forEach(System.out::println);




    }
}
