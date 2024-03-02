package org.example.concurrent.part1;

/**
 * 复现内存可见性问题案例
 * 两个线程同时执行1000次加一操作，理论上结果count应该是20000，实际却始终得到的是10000~20000之间的随机数
 * 原因就是多个CPU都缓存了count，各自执行时互不可见
 *
 * @author chensh
 * @datetime 2024/3/2 9:50 AM
 */
public class MemoryVisibility {
    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MemoryVisibility t = new MemoryVisibility();
        // 创建两个线程，执行累加操作
        Thread t1 = new Thread(t::add10K);
        Thread t2 = new Thread(t::add10K);

        // 启动两个线程
        t1.start();
        t2.start();

        // 等待两个线程结束
        t1.join();
        t2.join();

        System.out.printf("最终结果：%s", count);
    }
}
