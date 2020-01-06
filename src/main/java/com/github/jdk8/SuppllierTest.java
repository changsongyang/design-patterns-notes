package com.github.jdk8;
import com.github.jdk8.entity.Student;

import java.util.function.Supplier;

public class SuppllierTest {

    public static void main(String[] args) {

        //不接受参数 返回一个结果
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());

        //  lable表达式调用
        Supplier<Student>  supplier1 = () -> new Student();
        System.out.println(supplier1.get().getName());

        System.out.println("---------------");

//        四种形式的方法引用:
//        引用静态方法 ContainingClass::staticMethodName
//        引用某个对象的实例方法 containingObject::instanceMethodName
//        引用某个类型的任意对象的实例方法 ContainingType::methodName
//        引用构造方法 ClassName::new
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());



    }


}
