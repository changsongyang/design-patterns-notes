package com.github.jdk8;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
   Function接口可以用作lambda表达式或方法引用的赋值对象
   方法介绍:
        andThen: 返回一个组合函数，首先将该函数应用于其输入，然后将 after函数应用于结果
        compose: 先将 before函数应用于其输入，然后将此函数应用于结果。
        identity: 输入什么就返回什么
        apply: 将此函数应用于给定的参数
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        // 返回2   传一个参数a+后面传入函数式接口的行为 (以前是放在方法里实现 )
        System.out.println(test.compute(1,value -> 2 * value));
        System.out.println(test.compute(1,value -> 2 + value));
        System.out.println(test.compute(1,value -> value - value));

        // 返回12  先执行最后的函数式行为， 在执行前面的
        System.out.println(test.compose(2,value -> value * 3, value-> value * value));

        // 返回36  先执行前的函数式行为 在作为结果 执行最后的函数式行为
        System.out.println(test.compute2(2,value -> value * 3, value-> value * value));


        //  返回3  和Function的区别就是可以传入两个参数
        System.out.println(test.compute3(1,2,((a, b) -> a+b )));

        // 返回25  把 biFunction执行后得到的结果， 作为function的入参去执行
        System.out.println(test.compute4(2,3,(a, b) -> a+b, result -> result  * result ));


    }

    /**
     * 根据传入的参数和函数式接口 计算结果
     * @param a   参数
     * @param function  执行参数的行为 可以是任何行为,
     *                  function中第一个参数是入参类型，第二个参数是返回类型
     * @return
     */
    public  int compute(int a,Function<Integer,Integer> function){
        return  function.apply(a);
    }

    /**
     *  和andThen刚好相反
     *  把 function2执行后得到的结果， 作为function1的入参去执行
     * @return
     */
    public  int compose(int a,Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return  function1.compose(function2).apply(a);
    }

    /**
     *  把 function1执行后得到的结果， 作为function2的入参去执行
     * @return
     */
    public int compute2(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    /**
     * biFunction 表示接受两个参数并产生结果的函数
     *  BiFunction<T, U, R> T=函数第一个参数类型，U=函数第二个参数类型，R=返回结果类型
     * @return
     */
    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }
    /**
     *  biFunction 表示接受两个参数并产生结果的函数
     *  BiFunction<T, U, R> T=函数第一个参数类型，U=函数第二个参数类型，R=返回结果类型
     *
     *   把 biFunction执行后得到的结果， 作为function的入参去执行
     * @return
     */
    public int compute4(int a, int b, BiFunction<Integer,Integer,Integer> biFunction, Function<Integer,Integer> function){
        return biFunction.andThen(function).apply(a,b);
    }
}
