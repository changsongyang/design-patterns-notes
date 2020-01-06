package com.github.jdk8;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
    Predicat函数式接口的作用就是提供一个test方法，接受一个参数返回一个布尔类型。

 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length()> 5;
        // 返回false  字符串不大于5
        System.out.println(predicate.test("hello"));

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        PredicateTest predicateTest = new PredicateTest();

        // 输出偶数
        System.out.println("输出偶数.........");
        predicateTest.conditionFilter(list,integer -> integer % 2==0);

        // 输出非偶数
        System.out.println("输出非偶数........");
        predicateTest.conditionFilter(list,integer -> integer%2!=0);

        System.out.println("输出 所以大于5的元素....");
        predicateTest.conditionFilter(list,integer -> integer>5);

        // 默认执行true  全部输出列表
        System.out.println("默认执行true  全部输出列表..........");
        predicateTest.conditionFilter(list,integer -> true);

        // 大于5 且 都是偶数的元素
        System.out.println("如果predicate和predicate2两个函数行为都返回true  则输出元素....");
        predicateTest.conditionFilter2(list,integer -> integer > 5,integer -> integer % 2 ==0);


        System.out.println("如果两个值相同则 返回 ");
        //   如果两个值相同则 返回
        System.out.println(predicateTest.isEqual("test").test("test"));
        System.out.println(predicateTest.isEqual("test").test("啊啊啊"));
    }


    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer integer:list){
            // 返回true 则输出
            if (predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }


    public void conditionFilter2(List<Integer> list,Predicate<Integer> predicate,Predicate<Integer> predicate2){
        for (Integer integer:list){
            if (predicate.and(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }

    public Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }

}
