package org.example.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 定义只有2个线程的线程池，然后一次性提交五个任务，这两个线程不会销毁，而是一直交替处理任务
 *
 * @author chensh
 * @datetime 2024/3/16 4:01 PM
 */
public class ThreadPoolExample1 {
    public static void main(String[] args) {
        // 定义只有2个线程的线程池，然后一次性提交五个任务，这两个线程不会销毁，而是一直交替处理任务
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            WorkerThread workerThread = new WorkerThread("" + i);
            executorService.execute(workerThread);
        }

        // shutdown()方法是在合适的时候才会关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()){}
        System.out.println("all threads have finished");
        /*
        pool-1-thread-2 Start. Command = 1
        pool-1-thread-1 Start. Command = 0
        pool-1-thread-1 End.
        pool-1-thread-2 End.
        pool-1-thread-2 Start. Command = 2
        pool-1-thread-1 Start. Command = 3
        pool-1-thread-2 End.
        pool-1-thread-2 Start. Command = 4
        pool-1-thread-1 End.
        pool-1-thread-2 End.
        all threads have finished
         */
    }
}

class WorkerThread implements Runnable{
    private final String command;

    public WorkerThread(String command) {
        this.command = command;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
