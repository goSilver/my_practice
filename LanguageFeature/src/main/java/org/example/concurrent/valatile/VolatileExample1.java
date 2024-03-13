package org.example.concurrent.valatile;

import java.util.concurrent.TimeUnit;

/**
 * volatile解决可见性问题
 * 可见性问题主要指一个线程修改了共享变量值，而另一个线程却看不到。引起可见性问题的主要原因是每个线程拥有自己的一个高速缓存区——线程工作内存。
 *
 * @author chensh
 * @datetime 2024/3/13 9:12 PM
 */
public class VolatileExample1 {
    // 不加volatile关键字的变量，A线程会一直在while循环里自旋
    // private static boolean stop = false;

    // 加volatile关键字的变量，A线程会在主线程重置stop标志位后退出while循环
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread("Thread-A") {
            @Override
            public void run() {
                while (!stop) {
                    // 踩坑：println()方法内部有synchronized关键字影响可见性
                    // System.out.println(Thread.currentThread().getName() + "，stop标志=false，不断自旋中~");
                }
                System.out.println(Thread.currentThread().getName() + " stopped");
            }
        }.start();

        // 主线程sleep 1s然后将stop置为true
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread() + " sleep 1s");
        stop = true;
    }
}
