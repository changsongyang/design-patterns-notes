package com.github.design.composite;

public class CompositePatternTest {

    public static void main(String[] args) {
        // 使用 Employee 类来创建和打印员工的层次结构。

        Employee CEO = new Employee("zhangsan","CEO", 30000);

        Employee headSales = new Employee("lisi","Head Sales", 20000);
        Employee headMarketing = new Employee("wangwu","Head Marketing", 20000);

        CEO.add(headSales);
        CEO.add(headMarketing);


        Employee clerk1 = new Employee("55","Marketing", 10000);
        Employee clerk2 = new Employee("66","Marketing", 10000);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印该组织的所有员工
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println("1: "+headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println("2: "+employee);
            }
        }

    }
}
