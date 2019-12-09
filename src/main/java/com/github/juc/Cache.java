package com.github.juc;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能描述: 利用读写锁实现一个缓存类
 * @author: qinxuewu
 * @date: 2019/11/21 10:00
 * @since 1.0.0
 */
public class Cache<K,V> {
    final Map<K,V> m=new HashMap<K, V>();
    final ReadWriteLock rwl=new ReentrantReadWriteLock();
    // 读锁
    final Lock r=rwl.readLock();
    // 写锁
    final  Lock w=rwl.writeLock();

    V get(K key){

        r.lock();
        try {
           return m.get(key);
        }finally {
            r.unlock();
        }
    }


    V put(String key,Object v){
        w.lock();
        try {
            return  m.get(key);
        }finally {
            w.unlock();
        }
    }

}
