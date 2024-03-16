package org.example.concurrent.test;

import java.util.concurrent.TimeUnit;

/**
 * 题目：
 * 要求线程a执行完才开始线程b, 线程b执行完才开始线程c
 * <p>
 * 思路：
 * 基于Thread类的join()方法实现
 * <p>
 * join()的作用：
 * 主要作用是同步，它可以使得线程之间的并行执行变为串行执行。
 * 在A线程中调用了B线程的join()方法时，表示只有当B线程执行完毕时，A线程才能继续执行。
 *
 * @author chensh
 * @datetime 2024/3/16 8:37 PM
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // 创建三个线程
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        // 各自分别启动并等待自己结束
        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        System.out.println("main end");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " run()");
    }
}