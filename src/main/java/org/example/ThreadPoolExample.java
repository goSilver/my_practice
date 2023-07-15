package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个固定大小为5的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 提交任务给线程池
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("Task " + (i + 1));
            executor.execute(worker);
        }
        // 关闭线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("所有任务已经执行完毕");
    }
}

class WorkerThread implements Runnable {
    private String taskName;

    public WorkerThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("开始执行任务: " + taskName);
        try {
            // 模拟任务执行时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务完成: " + taskName);
    }
}
