package org.example.concurrent.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：
 * 两个线程，交替打印到100
 *
 * @author chensh
 * @datetime 2024/3/16 8:43 PM
 */
public class Test2 {
    private int num = 0;
    private final ReentrantLock lock = new ReentrantLock();

    private void printNum(int targetNum) {
        for (int i = 0; i < 50; ) {
            lock.lock();
            if (num % 2 == targetNum) {
                num++;
                i++; // 打印完一轮，再进入下一轮
                System.out.println(num);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test2 test2 = new Test2();
        new Thread(() -> test2.printNum(1)).start();
        new Thread(() -> test2.printNum(0)).start();
        Thread.sleep(3000);
    }
}
