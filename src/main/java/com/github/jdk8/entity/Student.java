package com.github.jdk8.entity;

public class Student {

    private String name = "zhangsan";
    private int age = 20;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public static int compareStudentByAge(Student student1,Student student2){
        return student1.getAge() - student2.getAge();
    }
    public static int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareToIgnoreCase(student2.name);
    }

    public int compareByAge(Student student){
        return this.getAge() - student.getAge();
    }

    public int compareByName(Student student){
        return this.getName().compareToIgnoreCase(student.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
