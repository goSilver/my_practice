package org.example.concurrent.synchronizedd;

/**
 * 在代码块上加锁，可以指定锁对象，多个锁对象之间互不影响
 *
 * @author chensh
 * @datetime 2024/3/13 6:54 PM
 */
public class SynchronizedObjectLock2 implements Runnable {

    static SynchronizedObjectLock2 instance = new SynchronizedObjectLock2();
    // 创建两把锁
    final Object block1 = new Object();
    final Object block2 = new Object();

    @Override
    public void run() {
        // 这个代码块使用的是第一把锁，当它释放后，后面的线程即可获取到锁
        synchronized (block1) {
            System.out.println("block1锁，当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block1，当前线程：" + Thread.currentThread().getName() + " 结束~ ");
        }

        synchronized (block2) {
            System.out.println("block2锁，当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block2，当前线程：" + Thread.currentThread().getName() + " 结束~ ");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        /*
        block1锁，当前线程：Thread-0
        block1，当前线程：Thread-0 结束~
        block2锁，当前线程：Thread-0
        block1锁，当前线程：Thread-1       // Thread-0释放锁1后，Thread-1立即获取到了锁1
        block1，当前线程：Thread-1 结束~
        block2，当前线程：Thread-0 结束~
        block2锁，当前线程：Thread-1
        block2，当前线程：Thread-1 结束~
         */
    }
}
