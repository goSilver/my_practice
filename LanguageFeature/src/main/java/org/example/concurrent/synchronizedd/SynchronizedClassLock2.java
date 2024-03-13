package org.example.concurrent.synchronizedd;

/**
 * 代码块指定锁对象为Class类，所有线程串行
 *
 * @author chensh
 * @datetime 2024/3/13 8:30 PM
 */
public class SynchronizedClassLock2 implements Runnable {
    @Override
    public void run() {
        // 所有线程竞争的锁对象都是同一个Class类
        synchronized (SynchronizedClassLock2.class) {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 结束");
        }
    }

    public static void main(String[] args) {
        // 锁对象都是Class对象，两个线程串行
        Thread t1 = new Thread(new SynchronizedClassLock2());
        Thread t2 = new Thread(new SynchronizedClassLock2());
        t1.start();
        t2.start();
        /*
        当前线程：Thread-0
        当前线程：Thread-0 结束
        当前线程：Thread-1
        当前线程：Thread-1 结束
         */
    }
}
