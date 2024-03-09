package org.example.concurrent.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 利用 Java 并发包提供的 Future 可以很容易获得异步任务的执行结果，无论异步任务是通过线程池 ThreadPoolExecutor 执行的，
 * 还是通过手工创建子线程来执行的。
 * <p>
 * 利用多线程可以快速将一些串行的任务并行化，从而提高性能；如果任务之间有依赖关系，比如当前任务依赖前一个任务的执行结果，
 * 这种问题基本上都可以用 Future 来解决。在分析这种问题的过程中，建议你用有向图描述一下任务之间的依赖关系，
 * 同时将线程的分工也做好，类似于烧水泡茶最优分工方案那幅图。对照图来写代码，好处是更形象，且不易出错。
 * @author chensh
 * @datetime 2024/3/9 1:09 PM
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建T2的FutureTask
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        // T1依赖T2
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));
        // 启动任务
        Thread t1 = new Thread(ft1);
        t1.start();
        Thread t2 = new Thread(ft2);
        t2.start();
        // 获取t1的任务结果
        System.out.println(ft1.get());
    }
}

class T1Task implements Callable<String> {
    FutureTask<String> ft2;
    // T1任务需要T2任务的FutureTask
    T1Task(FutureTask<String> ft2){ this.ft2 = ft2; }
    @Override
    public String call() throws Exception {
        System.out.println("T1 - 洗水壶 - 2s");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("T1 - 烧热水 - 5s");
        TimeUnit.SECONDS.sleep(5);
        // 阻塞等待获取ft2的茶叶
        String tea = ft2.get();
        System.out.println("T1 - 拿到茶叶：" + tea);
        System.out.println("T1 - 泡茶ing...");
        return "上茶 - " + tea;
    }
}

class T2Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("T2 - 洗茶壶 - 2s");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("T2 - 洗茶杯 - 1s");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2 - 拿茶叶 - 1s");
        TimeUnit.SECONDS.sleep(1);
        return "云南普洱~";
    }
}
