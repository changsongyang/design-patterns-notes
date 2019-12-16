package com.github.design.proxy;

/**
 * 〈〉
 *
 * @author qinxuewu
 * @create 19/8/29下午7:09
 * @since 1.0.0
 */


public class TeacherDao  implements  ITeacherDao{

    @Override
    public void teacher() {
        System.out.println(" 调用teacher。。。。。");
    }
}
