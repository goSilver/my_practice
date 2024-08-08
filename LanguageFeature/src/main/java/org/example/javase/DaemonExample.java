package org.example.javase;

/**
 * java中有两类线程，用户线程和守护线程
 * 用户线程：用来执行用户任务
 * 守护线程：用来执行后台任务，例如垃圾回收线程
 * 区别：JVM会等待所有用户线程结束才结束，而不等待守护线程
 */
public class DaemonExample {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.isDaemon());
        // 在线程启动之前setDaemon()，OK
        thread.setDaemon(true);
        System.out.println(thread.isDaemon());
        thread.start();
        // 在线程启动之后setDaemon()，报错java.lang.IllegalThreadStateException
        thread.setDaemon(false);
    }
}
