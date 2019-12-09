package com.github.design.proxy;

/**
 *  代理对象 静态代理
 *
 * @author qinxuewu
 * @create 19/8/29下午7:12
 * @since 1.0.0
 */


public class TeacherDaoProxy  implements  ITeacherDao  {

    // 目标对象  通过接口来聚合
    private  ITeacherDao target;

    public  TeacherDaoProxy(ITeacherDao target){
        this.target=target;
    }


    public void teacher() {
        System.out.println("开始代理 。。。。");
        target.teacher();
        System.out.println("代理完成.....");
    }
}
