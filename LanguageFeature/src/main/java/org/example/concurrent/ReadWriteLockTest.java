package org.example.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chensh
 * @datetime 2024/3/4 10:25 PM
 */
public class ReadWriteLockTest {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    final Lock r = lock.readLock();
    final Lock w = lock.writeLock();
    private String cache;

    String getCache() {
        r.lock();
        try {
            return cache;
        } finally {
            r.unlock();
        }
    }

    void setCache(String s) {
        w.lock();
        cache = s;
        w.unlock();
    }

    public static void main(String[] args) {
        ReadWriteLockTest rw = new ReadWriteLockTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Thread.currentThread().getName().startsWith("5")||
                            Thread.currentThread().getName().startsWith("6")||
                            Thread.currentThread().getName().startsWith("7")) {
                        System.out.println(Thread.currentThread().getName() + "，执行写缓存");
                     rw.setCache(Thread.currentThread().getName());
                    } else {
                        System.out.println(Thread.currentThread().getName() + "，执行读缓存，" + rw.getCache());
                    }
                }
            }, i+"号线程");
            thread.start();
        }
    }
}
