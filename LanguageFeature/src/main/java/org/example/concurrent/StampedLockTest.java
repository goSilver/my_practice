package org.example.concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock是ReadWriteLock的子集
 * 支持悲观锁&乐观锁
 * 乐观读这个操作是无锁的，所以相比较 ReadWriteLock 的读锁，乐观读的性能更好一些。
 * StampedLock 不支持重入
 *
 * @author chensh
 * @datetime 2024/3/4 10:25 PM
 */
public class StampedLockTest {
    private final StampedLock lock = new StampedLock();
    private String cache;

    String getCache() {
        // 乐观读锁
        long stamp = lock.tryOptimisticRead();
        try {
            return cache;
        } finally {
           lock.unlock(stamp);
        }
    }

    void setCache(String s) {
        // 悲观写锁
        long stamp = lock.writeLock();
        try{
            cache = s;
        } finally {
            lock.unlock(stamp);
        }
    }

    public static void main(String[] args) {
        StampedLockTest rw = new StampedLockTest();
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
