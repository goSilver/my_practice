package org.example.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 的计数器是可以循环利用的
 * CyclicBarrier 是一组线程之间互相等待
 *
 * @author chensh
 * @datetime 2024/3/5 9:37 PM
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        // 定义一个计数器为2的CyclicBarrier，并注册一个回调函数
        CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("登记入库...");
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("商品零件A到货...");
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("商品零件B到货...");
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();

    }
}
