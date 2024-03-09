package org.example.concurrent.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture的优势：
 * 1、无需手工维护线程，没有繁琐的手工维护线程的工作，给任务分配线程的工作也不需要我们关注；
 * 2、语义更清晰，例如 f3 = f1.thenCombine(f2, ()->{}) 能够清晰地表述“任务 3 要等待任务 1 和任务 2 都完成后才能开始”；
 * 3、代码更简练并且专注于业务逻辑，几乎所有代码都是业务逻辑相关的。
 *
 * @author chensh
 * @datetime 2024/3/9 2:29 PM
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        // 任务1：洗水壶->烧开水
        CompletableFuture<Void> ft1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶...");
            sleep(1);
            System.out.println("T1:烧开水...");
            sleep(5);
        });
        // 任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> ft2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            sleep(1);
            System.out.println("T2:洗茶杯...");
            sleep(2);
            System.out.println("T2:拿茶叶...");
            sleep(1);
            return "龙井";
        });
        CompletableFuture<String> ft3 = ft1.thenCombine(ft2, (__, tf) -> {
            System.out.println("T1:拿到茶叶:" + tf);
            System.out.println("T1:泡茶...");
            return "上茶:" + tf;
        });
        // 等待任务3执行结果
        System.out.println(ft3.join());
    }

    static void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}


