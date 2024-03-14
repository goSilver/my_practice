package org.example.concurrent.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 线程本地存储-ThreadLocal Storage
 * 将对象的可见性限制在本线程之内
 *
 * @author chensh
 * @datetime 2024/3/14 4:52 PM
 */
public class ThreadLocalExample1 {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程1设置threadLocal为1
                threadLocal.set(1);
                try {
                    // sleep一会等待线程2结束
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印threadLocal值，仍然是1
                System.out.println("threadLocal：" + threadLocal.get());
                // Tips：使用完ThreadLocal对象记得remove，以防线程池场景内存泄漏
                threadLocal.remove();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程2设置threadLocal值为2
                threadLocal.set(2);
                threadLocal.remove();
            }
        });

        // t1、t2两个线程的ThreadLocal对象完全互不影响
        t1.start();
        t2.start();
    }
}
