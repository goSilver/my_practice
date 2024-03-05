package org.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch用于多线程任务倒计时，强制等待一组线程的任务完成
 * CountDownLatch的计数器初始化后归零无法复原，区别与Semaphore可以通过release恢复计数
 *
 * @author chensh
 * @datetime 2024/3/5 9:16 PM
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "：do something...");
                    try {
                        Thread.sleep(1000*3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "：done...");
                        latch.countDown();
                    }
                }
            });
        }

        System.out.println("main thread waiting...");
        latch.await(20, TimeUnit.SECONDS);
        System.out.println("main thread done...");
        pool.shutdown();
        System.out.println("thread pool shutdown...");
    }
}
