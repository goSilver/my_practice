package org.example.concurrent.async;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 是一个并行计算的框架，主要就是用来支持分治任务模型的，这个计算框架里的 Fork 对应的是分治任务模型里的任务分解，
 * Join 对应的是结果合并。Fork/Join 计算框架主要包含两部分，一部分是分治任务的线程池 ForkJoinPool，
 * 另一部分是分治任务 ForkJoinTask。这两部分的关系类似于 ThreadPoolExecutor 和 Runnable 的关系，
 * 都可以理解为提交任务到线程池，只不过分治任务有自己独特类型 ForkJoinTask。
 * <p>
 * ForkJoinPool 支持任务窃取机制，能够让所有线程的工作量基本均衡，不会出现有的线程很忙，而有的线程很闲的状况，所以性能很好。
 * <p>
 * 默认情况下所有的并行流计算都共享一个 ForkJoinPool，这个共享的 ForkJoinPool 默认的线程数是 CPU 的核数，可配置启动参数。
 * @author chensh
 * @datetime 2024/3/9 2:49 PM
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) {
        // 创建分治任务线程池
        ForkJoinPool pool = new ForkJoinPool(4);
        // 创建分治任务
        int n = 10;
        Fibonacci fb = new Fibonacci(n);
        // 启动任务
        Integer res = pool.invoke(fb);
        System.out.println("第" + n + "个斐波那契数为：" + res);
    }
}

/**
 * 分治任务：计算斐波那契数
 */
class Fibonacci extends RecursiveTask<Integer> {
    int n;

    Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        // 创建子任务
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        // 等待子任务，合并结果
        return f2.compute() + f1.join();
    }
}