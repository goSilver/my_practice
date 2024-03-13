package org.example.concurrent.synchronizedd;

/**
 * synchronized修饰普通方法，锁对象默认为this
 *
 * @author chensh
 * @datetime 2024/3/13 8:18 PM
 */
public class SynchronizedObjectLock3 implements Runnable {
    static SynchronizedObjectLock3 instance = new SynchronizedObjectLock3();

    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
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
