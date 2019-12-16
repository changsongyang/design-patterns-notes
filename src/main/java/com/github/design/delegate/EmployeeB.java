package com.github.design.delegate;


/**
 * 功能描述: 委派模式  EmployeeB
 * @author: qinxuewu
 * @date: 2019/12/10 16:57
 * @since 1.0.0
 */
public class EmployeeB implements  IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工 B， 我现在开始干" + command + "工作");
    }
}
