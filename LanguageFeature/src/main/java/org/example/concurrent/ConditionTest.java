package org.example.concurrent;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensh
 * @datetime 2024/3/4 9:14 PM
 */
public class ConditionTest {
    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> bq = new BlockQueue<>();
        bq.enq(1);
        bq.enq(2);
        bq.enq(3);
        bq.deq();
        bq.enq(4);

        // [2, 3, 4]
        System.out.println(bq.queue.toString());
    }
}

class BlockQueue<T> {
    Queue<T> queue = new ArrayBlockingQueue<>(3);
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            // 队列已满，阻塞
            while (queue.size() == 3) {
                notFull.await();
            }
            // 入队
            queue.add(x);
            // 入队后通知可出队
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    void deq() throws InterruptedException {
        lock.lock();
        try {
            // 队列为空，阻塞
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            // 出队
            queue.poll();
            // 出队后通知入队
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
