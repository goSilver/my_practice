package org.example.concurrent.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 *
 * 思路：
 * 使用一个取模的判断逻辑 C%M ==N，题为 3 个线程，所以可以按取模结果编号：0、1、2，他们与 3 取模结果仍为本身，则执行打印逻辑。
 *
 * @author chensh
 * @datetime 2024/3/17 10:25 AM
 */
public class Test3 {
    // 控制打印次数
    private final int times;
    // 当前状态值，保证三个线程交替打印
    private int state;
    private final ReentrantLock lock = new ReentrantLock();

    public Test3(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++; // 三个线程同时执行完一轮打印ABC后才开启下一轮，所以要在此处i++
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test3 test3 = new Test3(3);
        new Thread(() -> test3.printLetter("A", 0)).start();
        new Thread(() -> test3.printLetter("B", 1)).start();
        new Thread(() -> test3.printLetter("C", 2)).start();
        Thread.sleep(1000);
    }
}
