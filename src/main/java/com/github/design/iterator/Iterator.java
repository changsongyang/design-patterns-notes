package com.github.design.iterator;


/**
 * 功能描述: 表示遍历集合的接口
 * @author: qinxuewu
 * @date: 2020/1/23 10:51
 * @since 1.0.0
 */
public interface Iterator {
    /**
     * 获取下一个元素
     * @return
     */
    public abstract   Object next();

    /**
     * 判断是否存在下一个元素
     * @return
     */
    public abstract boolean hashNext();
}
