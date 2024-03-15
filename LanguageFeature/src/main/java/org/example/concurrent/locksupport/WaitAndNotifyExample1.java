package org.example.concurrent.locksupport;

/**
 * 使用wait/notify实现线程同步
 * 必须先调用wait，后调用notify，如果先调用notify，再调用wait，将起不了作用。
 *
 * @author chensh
 * @datetime 2024/3/15 5:15 PM
 */
public class WaitAndNotifyExample1 extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("before notify()");
            notify();
            System.out.println("after notify()");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitAndNotifyExample1 thread = new WaitAndNotifyExample1();
        synchronized (thread) {
            thread.start();
            // 主线程sleep 3s
            Thread.sleep(3000);
            System.out.println("before wait()");
            thread.wait();  // 阻塞主线程
            System.out.println("after wait()");
            /*
            before wait()
            before notify()
            after notify()
            after wait()
             */
        }
    }
}
