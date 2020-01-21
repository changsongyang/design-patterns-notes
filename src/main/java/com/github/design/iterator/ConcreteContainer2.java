package com.github.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能描述: 内部有自带不同的迭代器
 *   一个Container的实现类都会有一个具体的Iterator实现类来帮助实现迭代；
 * @author: qinxuewu
 * @date: 2020/1/21 17:46
 * @since 1.0.0
 */
public class ConcreteContainer2  implements Container {
    public ArrayList arr;

    public ConcreteContainer2(ArrayList arr) {
        this.arr=arr;
    }
    @Override
    public Iterator getIterator() {
        return new ConcreteIterator1<Integer>();
    }

    private class ConcreteIterator1<E> implements Iterator{
        private int index;
        @Override
        public boolean hasNext() {
            return index < arr.size();
        }

        @Override
        public Object next() {
            if(hasNext())
                return arr.get(index++);
            return null;
        }
    }
}
