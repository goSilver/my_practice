package org.example.concurrent.synchronizedd;

/**
 * 同步代码块形式：多个线程竞争相同的锁，后面的线程必须等待前面的线程释放锁了才能执行
 *
 * @author chensh
 * @datetime 2024/3/12 9:04 PM
 */
public class SynchronizedObjectLock1 implements Runnable {
    static SynchronizedObjectLock1 instance = new SynchronizedObjectLock1();
    @Override
    public void run() {
        // 同步代码块形式：多个线程竞争相同的锁，后面的线程必须等待前面的线程释放锁了才能执行
        synchronized (this) {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 结束 ");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        /*
        输出：
        当前线程：Thread-0
        当前线程：Thread-0 结束
        当前线程：Thread-1
        当前线程：Thread-1 结束
         */
    }
}
