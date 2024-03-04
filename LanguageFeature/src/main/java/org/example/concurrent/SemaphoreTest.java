package org.example.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore允许多个线程同时进入临界区
 * @author chensh
 * @datetime 2024/3/4 10:01 PM
 */
public class SemaphoreTest {
    private static final Semaphore sem = new Semaphore(3);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("==="+ Thread.currentThread().getName()+"来到停车场");
                        if (sem.availablePermits() == 0) {
                            System.out.println("车位不足，请耐心等待");
                        }
                        sem.tryAcquire();
                        System.out.println(Thread.currentThread().getName()+"成功进入停车场");
                        Thread.sleep(5000);

                        System.out.println(Thread.currentThread().getName()+"驶离停车场");
                        sem.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i+"号车");
            thread.start();
        }
    }
}
