package org.example.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 类：
 * java.util.concurrent 类库中提供了 Condition 类来实现线程之间的协调，可以在 Condition 上调用 await() 方法使线程等待，
 * 其它线程调用 signal() 或 signalAll() 方法唤醒等待的线程。相比于 wait() 这种等待方式，await() 可以指定等待的条件，因此更加灵活。
 *
 * @author chensh
 * @datetime 2024/3/15 11:47 AM
 */
public class ConditionExample2 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void before() {
        // 加锁
        lock.lock();
        try {
            System.out.println("before");
            // 唤醒等待线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        // 加锁
        lock.lock();
        try {
            // 等待通知
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ConditionExample2 example2 = new ConditionExample2();
        // 先调用after，再调用before
        executorService.execute(example2::after);
        executorService.execute(example2::before);
        /*
        before
        after
         */
    }

}
