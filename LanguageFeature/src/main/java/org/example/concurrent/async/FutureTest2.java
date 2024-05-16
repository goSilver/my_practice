package org.example.concurrent.async;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author chensh
 * @datetime 2024/5/15 4:13 PM
 */
public class FutureTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.NANOSECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        List<CompletableFuture<String>> futures = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (String s : list) {
            System.out.println("提交异步任务：" + s);
            futures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("任务执行ing：" + s + " -- " + LocalDateTime.now());
                    Thread.sleep(2000);
                    System.out.println("任务执行end：" + s + " -- " + LocalDateTime.now());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return s;
            },threadPoolExecutor ));
            System.out.println("提交异步任务完成：" +s);
        }

        System.out.println("所有异步任务提交完成--");

        // 等待异步结果
        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{}));
        resultFuture.get();
        for (CompletableFuture<String> future : futures) {
            if (future.get() != null) {
               System.out.println(future.get());
            }
        }

        threadPoolExecutor.shutdown();
    }
}
