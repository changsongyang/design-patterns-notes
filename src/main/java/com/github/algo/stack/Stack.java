package com.github.algo.stack;

/**
 *  数据结构  使用数组实现栈
 *
 * @author qinxuewu
 * @create 20/2/15下午1:04
 * @since 1.0.0
 */

public class Stack<E> {
    /**
     * 所有的元素
     */
    private E[] elements;
    // 默认数组大小
    private static final int DEFAULT_CAPACITY = 10;


    /**
     * 初始化栈大小
     * @param capaticy
     */
    public Stack(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }
    public  Stack(){
        this(DEFAULT_CAPACITY);
    }

    private  int  size;

    /**
     * 元素的数量
     * @return
     */
   public int size(){
        return  size;
    }

    /**
     * 是否为空
     * @return
     */
    public  boolean isEmpty(){
        return  size==0;
    }

    /**
     * 入栈
     * @param element
     */
    public void  push(E element){
        // 入栈前先执行数据检查 是否需要扩容
        ensuerCapactiy(size+1);
        //  入栈添加元素到尾部
        elements[size]=element;
        size++;
    }


    /**
     * 出栈  从尾部出
     * @return
     */
    public  E pop(){
        // 尾部溢出 不需要移动数组元素
        E old=elements[size-1];
        elements[--size]=null;
        return  old;
    }


    /**
     * 访问栈顶元素
     * @return
     */
    public  E top(){
        return  elements[size-1];
    }

    /**
     * 清空
     */
    void  clear(){
        for (int i=0;i< size;i++){
            elements[i]=null;
        }
        size=0;
    }


    /**
     * 数组扩容
     * @param capacity
     */
    private  void  ensuerCapactiy(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新的容量为旧容量的1.倍
        int newCapacity=oldCapacity+(oldCapacity >> 1);
        // 元素移动
        E [] newElements=(E[])new Object[newCapacity];

        for (int i = 0; i <size ; i++) {
            newElements[i]=elements[i];
        }
        elements=newElements;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
