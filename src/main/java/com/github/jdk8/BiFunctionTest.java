package com.github.jdk8;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
   biFunction 表示接受两个参数并产生结果的函数
 */
public class BiFunctionTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan",20);
        Person person2 = new Person("lisi",30);
        Person person3 = new Person("wangwu",40);

        List<Person> personList = Arrays.asList(person1,person2,person3);

        BiFunctionTest test = new BiFunctionTest();

        System.out.println("根据姓名过滤   返回和入参相同的name的元素....");
        List<Person> personResult = test.getPersonByUsername("zhangsan",personList);
        personResult.forEach(person -> System.out.println(person.getUsername()));

        System.out.println("根据年龄过滤  返回大于传入指定age的元素....");
        List<Person> personResult2 = test.getPersonByAge(20,personList);
        personResult2.forEach(person -> System.out.println(person.getAge()));


        System.out.println("根据年龄过滤  过滤行为不在方法中实现 而是在调用方实现");
        List<Person> personResult3 = test.getPersonsByAge2(30,personList,(age,persons)->
                persons.stream().filter(person -> person.getAge()>age).collect(Collectors.toList())
        );
        personResult3.forEach(person -> System.out.println(person.getAge()));
    }

    /**
     * 根据姓名过滤   返回和入参相同的name的元素 ， 原地过滤
     * @return
     */
    public List<Person> getPersonByUsername(String username,List<Person> persons){
        return persons.stream().filter(person -> person.getUsername().equals(username)).
                collect(Collectors.toList());
    }

    /**
     *  根据年龄果粒橙  返回大于传入指定age的元素
     *  传入指定的age,和元素集合  返回一个新的结果  biFunction接收两个参数类型 返回一个结果类型
     * @return
     */
    public List<Person> getPersonByAge(int age,List<Person> persons){
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson, personList)->
                personList.stream().filter(person -> person.getAge()>ageOfPerson).collect(Collectors.toList());

        return biFunction.apply(age,persons);
    }

    public List<Person> getPersonsByAge2(int age,List<Person> persons,BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,persons);
    }

  public static class Person {
      private String username;
      private int age;
      public Person(String username, int age) {
          this.username = username;
          this.age = age;
      }
      public String getUsername() { return username; }
      public void setUsername(String username) { this.username = username; }
      public int getAge() { return age; }
      public void setAge(int age) { this.age = age; }
  }
}
