package com.github.algo.heap;


/**
 * 功能描述:  堆的公共接口
 * @author: qinxuewu
 * @date: 2020/3/6 10:48
 * @since 1.0.0
 */
public interface Heap<E> {
    /**
     * 元素的数量
     * @return
     */
    int size();
    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
    /**
     * 清空
     * @return
     */
    void clear();
    /**
     * 添加元素
     * @return
     */
    void add(E element);
    /**
     * 获得堆顶元素
     * @return
     */
    E get();
    /**
     * 删除堆顶元素
     * @return
     */
    E remove();
    /**
     * 删除堆顶元素的同时插入一个新元素
     * @return
     */
    E replace(E element);
}
