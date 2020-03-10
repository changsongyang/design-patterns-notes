package com.github.design.iterator;


/**
 * 功能描述:  表示集合的接口
 * @author: qinxuewu
 * @date: 2020/1/23 10:57
 * @since 1.0.0
 */
public interface Aggregate {

    /**
     * 该方法用于生成遍历集合的迭代器
     * @return
     */
    public abstract Iterator iterator();
}
