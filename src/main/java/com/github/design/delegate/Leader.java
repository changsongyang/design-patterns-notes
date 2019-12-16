package com.github.design.delegate;


import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:  委派模式  项目经理
 * @author: qinxuewu
 * @date: 2019/12/10 16:58
 * @since 1.0.0
 */
public class Leader implements  IEmployee {
    private Map<String,IEmployee> targets = new HashMap<String,IEmployee>();

    public Leader() {
        targets.put("加密",new EmployeeA());
        targets.put("登录",new EmployeeB());
    }

    // 项目目经理自己不干活， 根据不同的命令 分配不同的员工去执行
    @Override
    public void doing(String command){
        targets.get(command).doing(command);
    }
}
