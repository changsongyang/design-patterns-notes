package com.github.jdk8;
import com.github.jdk8.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 功能描述:   JDK8  四种形式的方法引用:
         引用静态方法 ContainingClass::staticMethodName
         引用某个对象的实例方法 containingObject::instanceMethodName
         引用某个类型的任意对象的实例方法 ContainingType::methodName
         引用构造方法 ClassName::new
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",90);
        Student student3 = new Student("wangwu",50);
        Student student4 = new Student("zhaoliu",40);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);


         // 原始方法
//        students.sort((studentParam1,studentParam2)->Student.compareStudentByAge(studentParam1,studentParam2));
        students.sort(Student::compareStudentByAge);
        // 静态方法引用  根据年龄升序排序
        students.forEach(student -> System.out.println(student.getAge()));

        System.out.println("---------------");


        List<String> cities = Arrays.asList("qingdao","chongqing","tianjing","beijing");
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
         // 实例方法引用
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello",String::new));
//        System.out.println(methodReferenceTest.getString2("hello",s -> s+"66666"));
    }

    public String getString(Supplier<String> supplier){
        return supplier.get() +"test";
    }

    public String getString2(String str, Function<String,String> function){
        return function.apply(str);
    }
}
