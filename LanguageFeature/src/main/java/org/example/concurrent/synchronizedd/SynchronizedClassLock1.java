package org.example.concurrent.synchronizedd;

/**
 * synchronized用在静态方法上，默认的锁就是当前所在的Class类
 *
 * @author chensh
 * @datetime 2024/3/13 8:22 PM
 */
public class SynchronizedClassLock1 implements Runnable{
    @Override
    public void run() {
        method();
    }

    // synchronized用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，锁都只有一把
    public static synchronized void method() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 结束");
    }

    public static void main(String[] args) {
        // 锁对象都是Class对象，两个线程串行
        Thread t3 = new Thread(new SynchronizedClassLock1());
        Thread t4 = new Thread(new SynchronizedClassLock1());
        t3.start();
        t4.start();
        /*
        当前线程：Thread-0
        当前线程：Thread-0 结束
        当前线程：Thread-1
        当前线程：Thread-1 结束
         */
    }
}
