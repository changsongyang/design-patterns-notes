package juc;


import java.util.concurrent.locks.StampedLock;

/**
 * 功能描述:   StampedLock 支持三种模式，分别是：写锁、悲观读锁和乐观读。
 *  写锁、悲观读锁的语义和 ReadWriteLock 的写锁、读锁的语义非常类似，允许多个线程同时获取悲观读锁，
 *  但是只允许一个线程获取写锁，写锁和悲观读锁是互斥的。
 *
 *   ReadWriteLock 支持多个线程同时读，但是当多个线程同时读的时候，所有的写操作会被阻塞
 *   StampedLock 提供的乐观读，是允许一个线程获取写锁的，也就是说不是所有的写操作都被阻塞
 *
 *  使用 StampedLock 一定不要调用中断操作，如果需要支持中断功能，一定使用可中断的
 * 悲观读锁 readLockInterruptibly() 和写锁 writeLockInterruptibly()
 *
 * @author: qinxuewu
 * @date: 2019/11/21 10:15
 * @since 1.0.0 
 */
public class StampedLockTest {

    public static void main(String[] args) {
        final StampedLock s1=new StampedLock();
        // 获取 / 释放悲观读锁⽰意代码
        long stamp = s1.readLock();
        try {
            //业务代码
        }finally {
            s1.unlockRead(stamp);
        }
        long stemp=s1.writeLock();
        try {
            //业务代码
        }finally {
            s1.unlockWrite(stamp);
        }


        // 乐观读
        long s =s1.tryOptimisticRead();
        // 读⼊⽅法局部变量
        if(!s1.validate(s)){
            // 升级为悲观锁
            stamp=s1.readLock();
            try {
            // 读⼊⽅法局部变量
            } finally {
                // 释放悲观读锁
                s1.unlockRead(stamp);
            }
        }


    }



}
