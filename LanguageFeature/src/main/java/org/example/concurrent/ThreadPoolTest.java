package org.example.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * 不建议使用 Executors 的最重要的原因是：Executors 提供的很多方法默认使用的都是无界的 LinkedBlockingQueue，
 * 高负载情境下，无界队列很容易导致 OOM，而 OOM 会导致所有请求都无法处理，这是致命问题。所以强烈建议使用有界队列。
 * @author chensh
 * @datetime 2024/3/5 9:46 PM
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // maximumPoolSize设置为2 ，拒绝策略为AbortPolicy策略，直接抛出异常
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2,
                1000, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadTask());
        }
    }
}

class ThreadTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " do something...");
    }
}
