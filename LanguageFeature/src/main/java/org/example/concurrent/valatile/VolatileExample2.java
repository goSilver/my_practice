package org.example.concurrent.valatile;

/**
 * volatile不能保证完全的原子性，只能保证单次的读/写操作具有原子性。
 *
 * @author chensh
 * @datetime 2024/3/13 9:54 PM
 */
public class VolatileExample2 {

    volatile int num;

    /**
     * 即使num变量使用了volatile修饰，但是由于i++不具备原子性，并发情况下还是会出现问题
     * i++其实是一个复合操作，包括三步骤：
     * 1、读取i的值。
     * 2、对i加1。
     * 3、将i的值写回内存。
     */
    public void addNum() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample2 example2 = new VolatileExample2();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // sleep一下增加并发问题产生的几率
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    example2.addNum();
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println("num：" + example2.num);
        /*
        num：982
         */
    }
}
