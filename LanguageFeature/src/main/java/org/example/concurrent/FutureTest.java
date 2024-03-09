package org.example.concurrent;

import java.util.concurrent.*;

/**
 * @author chensh
 * @datetime 2024/3/9 12:46 PM
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        // Result对象用于主子线程之间通信
        Result r = new Result();
        r.setName("visitor");
        // 提交任务，获取future对象
        Future<Result> future = es.submit(new Task(r), r);
        // future对象阻塞式等待获取结果
        Result result = future.get();
        System.out.println("future get的name：" + result.getName());
        // 中断线程
        future.cancel(false);
        es.shutdown();
    }
}

class Task implements Runnable {
     Result result;
     Task(Result result) {
         this.result = result;
     }

    @Override
    public void run() {
        String name = result.getName();
        System.out.println("当前name：" + name);
        result.setName("admin");
        System.out.println("set admin");
    }
}

class Result {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

