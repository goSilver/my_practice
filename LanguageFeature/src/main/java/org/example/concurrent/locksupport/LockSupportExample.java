package org.example.concurrent.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用park/unpark实现线程同步
 * 先调用unpark，再调用park时，仍能够正确实现同步，不会造成由wait/notify调用顺序不当所引起的阻塞。因此park/unpark相比wait/notify更加的灵活。
 *
 * @author chensh
 * @datetime 2024/3/15 5:39 PM
 */
public class LockSupportExample extends Thread {
    private final Object object;

    public LockSupportExample(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

        System.out.println("after unpark");
    }

    public static void main(String[] args) {
        LockSupportExample myThread = new LockSupportExample(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
        /*
        before park
        before unpark
        Blocker info ParkAndUnparkDemo
        after park
        Blocker info null
        after unpark
         */
    }
}
