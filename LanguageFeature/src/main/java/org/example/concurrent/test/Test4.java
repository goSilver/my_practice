package org.example.concurrent.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：
 * 两个线程交替打印数字与字母，格式如下：12A34B56C78D910E
 *
 * @author chensh
 * @datetime 2024/3/17 12:35 PM
 */
public class Test4 {
    // 两个线程协作的共享变量，初始值赋1，使得先打印数字开始
    private int state = 1;
    private Character character = 'A';
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 打印字母
     */
    private void printCharacter() {
        for (int i = 0; i < 5;) {
            lock.lock();
            // state每累加三次打印一次字母
            if (state % 3 == 0) {
                System.out.print(character);
                i++;
                state++;
                character++;
            }
            lock.unlock();
        }
    }

    /**
     * 打印数字
     */
    private void printNumber() {
        for (int i = 0; i < 10;) {
            lock.lock();
            // state每累加三次打印二次数字
            if (state % 3 != 0) {
                i++;
                state++;
                // 这里打印i值
                System.out.print(i);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test4 test4 = new Test4();
        new Thread(test4::printCharacter).start();
        new Thread(test4::printNumber).start();
        Thread.sleep(1000);
    }
}
