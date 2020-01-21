package com.github.design.iterator;


/**
 * 功能描述:  迭代器接口   定义了 hasNext() 和 next() 方法
 * @author: qinxuewu
 * @date: 2020/1/21 17:40
 * @since 1.0.0
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
