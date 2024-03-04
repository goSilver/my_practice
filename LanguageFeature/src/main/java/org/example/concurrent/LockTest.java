package org.example.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensh
 * @datetime 2024/3/4 9:00 PM
 */
public class LockTest {
    private static long count = 0;
    // 定义ReentrantLock，他的构造函数可带一个bool值，代表是否创建一个公平锁或非公平锁
    private final Lock rtl = new ReentrantLock();

    private void add10k() {
        // 加锁
        rtl.lock();
        try {
            int idx = 0;
            while (idx++ < 10000) {
                count += 1;
            }
        } finally {
            // 释放锁
            rtl.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest t = new LockTest();
        // 创建两个线程，执行累加操作
        Thread t1 = new Thread(t::add10k);
        Thread t2 = new Thread(t::add10k);

        // 启动两个线程
        t1.start();
        t2.start();

        // 等待两个线程结束
        t1.join();
        t2.join();

        System.out.printf("最终结果：%s", count);
    }
}
