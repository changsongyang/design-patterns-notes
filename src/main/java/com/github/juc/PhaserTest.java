package com.github.juc;


import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 功能描述:  CyclicBarrier 的使用，在初始化时需要指定参与者数量，并且无法更改。
 * 而 Phaser 可以灵活的添加参与者，以及动态注销参与者，从而更加灵活地协同线程工作。
 *
 *  Phaser 中涉及到的两个重要概念：
 *      1.hase。Phaser 对阶段进行管理，而 phase 就是阶段，可以是阶段 1、阶段 2、阶段 3…… 当所有的参与者到达某个阶段屏障点时，phaser 会进入下一个阶段；
 *      2.party。参与者，Phase r 中会记录参与者的数量，可以通过 register 方法来添加，或者通过 arriveAndDeregister 来注销。
 *
 *  Phaser 的主要 API：
 *      register ()：参与者数量加一；
 *      arrive ()：参与者到达屏障点，到达数量加一。但是不会阻塞调用此方法的线程；
 *      arriveAndAwaitAdvance ()：参与者到达屏障点，到达数量加一。阻塞线程直到所有的参与者到达该 phase 轮次；
 *      arriveAndDeregister ()：参与者到达屏障点，到达数量加一。然后从 Phase 注销掉一个参与者，参与者减一；
 *      awaitAdvance (int phase)：阻塞所有的参与者到达该 phaser 的指定轮次。如果当前轮次和 phase 值不同或者 phase 已被终止时，会立即返回；
 *      awaitAdvanceInterruptibly (int phase)：功能同上，但是可以被打断；
 *      awaitAdvanceInterruptibly (int phase, long timeout, TimeUnit unit)：功能同上，但是只阻塞指定的时长；
 *      bulkRegister (int parties)：批量注册参与者；
 *      forceTermination ()：终止当前 phaser，改变其状态为 termination；
 *      onAdvance ()：阶段达成时被调用，子类可以对其重写。。
 */
public class PhaserTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        //主线程注册
        phaser.register();
        //10个学生线程分别启动开始考试，然后交卷，交卷后通知phaser已到达并且注销
        IntStream.range(1,10).forEach(number->{
            phaser.register();
            Thread student= new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("学生"+number+"交卷");
                phaser.arriveAndDeregister();
            });
            student.start();
        });
        //学生并行考试时，主线程会先执行到此行代码，但由于本phase还没有达成，所以阻塞在此
        phaser.arriveAndAwaitAdvance();
        //所有学生达成后，开始新的phase，下面启动三个老师线程，开始判卷
        IntStream.range(1,3).forEach(number->{
            phaser.register();
            Thread teacher= new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("老师"+number+"判卷完成");
                phaser.arriveAndDeregister();
            });
            teacher.start();
        });
        //老师判卷时，主线程会先执行到此行代码，但由于本phase还没有达成，所以阻塞在此
        phaser.arriveAndAwaitAdvance();
        //所有老师都达成后，开始新的phase，下面启动三个辅导员线程，公布成绩
        IntStream.range(1,3).forEach(number->{
            phaser.register();
            Thread counsellor= new Thread(()->{
                System.out.println("辅导员"+number+"公布成绩完成");
                phaser.arriveAndDeregister();
            });
            counsellor.start();
        });
    }


}

