package com.github.algo.heap;


import java.util.Comparator;

/**
 * 功能描述:  抽象堆类  公共方法的实现
 * @author: qinxuewu
 * @date: 2020/3/6 10:49
 * @since 1.0.0
 */
public  abstract  class AbstractHeap<E> implements Heap<E> {
    protected  int size;
    /**
     *  比较器
     */
    protected Comparator<E> comparator;

    public  AbstractHeap(Comparator<E> comparator){
        this.comparator=comparator;
    }

    public  AbstractHeap(){
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 传入两个元素 比较大小
     * @param e1
     * @param e2
     * @return
     */
    protected int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2)
                : ((Comparable<E>)e1).compareTo(e2);
    }
}
