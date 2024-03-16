package org.example.concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 编程题：
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
 *
 * @author chensh
 * @datetime 2024/3/16 5:09 PM
 */
public class CountDownLatchExample2 {
    private static List<Integer> list = new ArrayList<>();

    public void add(int i){
        list.add(i);
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchExample2 container = new CountDownLatchExample2();
        CountDownLatch latch = new CountDownLatch(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程1，before await()");
                    latch.await();
                    System.out.println("线程1，after await()");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("list的数量已达到：" + container.getSize());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    container.add(i);
                    System.out.println("线程2添加元素：" + i);
                    latch.countDown();
                }
            }
        }).start();
    }
}
