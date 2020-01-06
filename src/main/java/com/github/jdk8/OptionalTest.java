package com.github.jdk8;


import com.github.jdk8.entity.Company;
import com.github.jdk8.entity.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 功能描述:   jdk8 非空判断
 * @author: qinxuewu
 * @date: 2020/1/6 15:25
 * @since 1.0.0
 */
public class OptionalTest {
    public static void main(String[] args) {
        //  Optional.of(""); 此方法不允许传入null值
        Optional<String> optional = Optional.ofNullable(null);

        // 不为空（null）才会输出，为空则不执行
        optional.ifPresent(item -> System.out.println(item));

        // 当Optonal的值是空值时(null 空字符串不算)，无论orElse还是orElseGet都会执行；
        // 而当返回的Optional有值时，orElse会执行，而orElseGet不会执行
        System.out.println(optional.orElse("world"));
        System.out.println(optional.orElseGet(()->"nihao"));


        System.out.println("--------------------------------------------------------------");
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee,employee2);
//        company.setEmployees(employees);

        List<Employee> list = company.getEmployees();
        Optional<Company> optional2 = Optional.ofNullable(company);

        // map 映射  如果员工集合为null 则输出空集合
        System.out.println(optional2.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));

    }


}
