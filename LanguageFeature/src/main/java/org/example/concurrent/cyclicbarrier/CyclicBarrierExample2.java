package org.example.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 * @author chensh
 * @datetime 2024/3/16 7:11 PM
 */
public class CyclicBarrierExample2 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        // 定义CyclicBarrier并设置计数器为3，并注册一个回调方法
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");
            }
        });

        // 创建两个线程并启动
        MyThread t1 = new MyThread(barrier);
        MyThread t2 = new MyThread(barrier);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " going to await");

        // 主线程等待
        barrier.await();
        System.out.println(Thread.currentThread().getName() + " continue");
    }
}

class MyThread extends Thread {
    // 定义CyclicBarrier成员变量，并通过构造函数赋值
    private final CyclicBarrier barrier;
    public MyThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");
        try {
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
