package com.github.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;


/**
 * 功能描述:  表示对同一类型的两个操作数的操作，产生与操作数相同类型的结果和BiFunction 不同的是  它限制了类型
 *  BinaryOperator<T> extends BiFunction<T,T,T>  第一个参数，第二个参数 返回值必须是相同的类型
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest =new BinaryOperatorTest();
        // 返回3  传入两个参数 执行指定的操作行为 比如加减
        System.out.println(binaryOperatorTest.compute(1,2,(a,b)->a+b));

        System.out.println("------------");
        // 返回a,b字符串 最短的那一个
        System.out.println(binaryOperatorTest.getShort("hello123","world",(a,b)->a.length()-b.length()));

        // 返回 安首字母排序 最小的那个
        System.out.println(binaryOperatorTest.getShort("hello123","world",(a,b)->a.charAt(0)-b.charAt(0)));
    }

    /**
     *  传入两个参数 执行指定的操作行为
     * @return
     */
    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

    /**
     *  判断a,b字符串  返回最短的字符串
     * @return
     */
    public String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);
    }
}
