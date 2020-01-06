package com.github.jdk8;


/**
 * 功能描述:  函数接口
 *  1。 如果一个接口只有一个抽象方法 那么编译器会默认它是一个函数式接口， 重新的object类的方法 不算
 *  2 如果一个接口使用@FunctionalInterface注解修饰 那么编译器就会要求它按照函数式接口来定义
 *
 */
@FunctionalInterface
public interface FunctionInteaceTest1 {
    /**
     * 非抽象方法
     */
    void  test1();



    default void  test2(){
        System.out.println("jdk8 接口新增的default默认方法");
    }

}

class  Test{
    /**
     * 传入一个函数式接口的行为
     * @param functionInteaceTest1
     */
    public  void  test(FunctionInteaceTest1 functionInteaceTest1){
        System.out.println("start.......");
        functionInteaceTest1.test1();
        System.out.println("end...........");
    }
    public static void main(String[] args) {
        // 内部类形式的调用
        FunctionInteaceTest1 t1= new FunctionInteaceTest1() {
            @Override
            public void test1() {
                System.out.println("aaaaaaaaaa");
            }
        };
        t1.test1();

        // lambel表达式类形式的调用
        FunctionInteaceTest1 t2= () -> System.out.println("bbbbbbbbb");
        t2.test1();

        // 传入一个lambel表达式到普通的方法中
        Test test=new Test();
        test.test(t2);

    }
}
