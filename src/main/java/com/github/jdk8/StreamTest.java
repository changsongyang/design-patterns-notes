package com.github.jdk8;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        //创建一个流
        Stream stream = Stream.of("hello","world","hello world");
        stream.forEach(System.out::println);


        // 把一个数组转换成流
        String[] myArray = new String[]{"hello","world","hello world"};
        Stream stream2 = Arrays.stream(myArray);
        Stream stream1 = Stream.of(myArray);

        // 集合转成流
        List<String> list = Arrays.asList(myArray);
        Stream stream3 = list.stream();

        System.out.println("==========================");
        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);

        // 生产一个流， 包含3，不包含8
        System.out.println(" 生产一个流， 包含3，不包含8================");
        IntStream.range(3,8).forEach(System.out::println);

        System.out.println("生产一个流，开始位置和结束位置都包含================");
        IntStream.rangeClosed(3,8).forEach(System.out::println);


        // 流操作 都是到最后有结束 (比如 reduce)操作时 才会去真正的执行 使用的是懒加载的思想
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);

        System.out.println(" 利用map映射 把集合中每个元素乘以2  在做sum求和");
        // 2+4+6+8+10+12 = 42
        System.out.println(list2.stream().map(i->2*i).reduce(0,Integer::sum));

        // 创建一个字符串数组流
        Stream<String> stream4 = Stream.of("hello","world","hello world");
        // 使用方法引用 把流转换成一个数组
        System.out.println("使用方法引用 把流转换成一个数组..........");
        String[] stringss = stream4.toArray(String[]::new);
        Arrays.asList(stringss).forEach(System.out::println);


        //  把流转集合的集中方法
          Stream<String> stream5= Stream.of("hello","world","hello world");
         List<String> list5 = stream5.collect(Collectors.toList());
/*        List<String>  list5 = stream.collect(()->new ArrayList(),(theList, item)->theList.add(item),
                (thelist1,thelist2)->thelist1.addAll(thelist2));*/
        //   List<String> list = stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        // list.forEach(System.out::println);

          /* Stream<String> stream = Stream.of("hello","world","hello world");
        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        */

          // 流转成set集合
        Stream<String> stream6 = Stream.of("hello","world","hello world");
        Set<String> set= stream6.collect(Collectors.toCollection(TreeSet::new));

        // 把一个流中的所有字符串 追加在一起
        Stream<String> stream7 = Stream.of("hello","world","hello world");
        String str = stream7.collect(Collectors.joining()).toString();

        System.out.println("通过流把集合中的字符串转大写输出......");
        List<String> list7 = Arrays.asList("hello","world","hello world");
        list7.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("集合中的数 相乘。。。。。。。");
        List<Integer> list8 = Arrays.asList(1,2,3,4,5);
        list8.stream().map(item->item*item).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("使用流构造多个集合。。。。。。。。。");
        Stream<List<Integer>> stream8= Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6));
        stream8.flatMap(thrList->thrList.stream()).map(item->item*item).forEach(System.out::println);



    }
}
