package com.github.design.iterator;

import java.util.Iterator;


/**
 * 功能描述: 容器的实现类  多种不同的类 比如数组 集合等
 *   一个Container的实现类都会有一个具体的Iterator实现类来帮助实现迭代；
 * @author: qinxuewu
 * @date: 2020/1/21 17:46
 * @since 1.0.0
 */
public class ConcreteContainer1  implements  Container {
    public Integer[] arr;
    public ConcreteContainer1(Integer[] arr) {
      this.arr=arr;
    }
    @Override
    public Iterator getIterator() {
        return new ConcreteIterator1<Integer>();
    }

     private class ConcreteIterator1<E> implements Iterator{
      private   int index;
        @Override
        public boolean hasNext() {
            return index < arr.length;
        }
        @Override
        public Object next() {
            if(hasNext())
                return arr[index++];
            return null;
        }
    }
}
