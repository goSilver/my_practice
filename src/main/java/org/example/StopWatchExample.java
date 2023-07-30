package org.example;

import org.springframework.util.StopWatch;

/**
 * @author goku
 */
public class StopWatchExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个StopWatch实例
        StopWatch stopWatch = new StopWatch("测试哦");
        // 开始计时
        stopWatch.start("循环a");
        // 模拟一些代码执行
        for (int i = 0; i < 10; i++) {
            // do something
            Thread.sleep(100);
        }
        // 停止计时
        stopWatch.stop();
        // 开始计时
        stopWatch.start("循环b");
        // 模拟一些代码执行
        for (int i = 0; i < 20; i++) {
            // do something
            Thread.sleep(100);
        }
        // 停止计时
        stopWatch.stop();
        // 获取总的执行时间，以毫秒为单位
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        // 获取格式化的执行时间
        String formattedTime = stopWatch.toString();
        // 输出结果
        System.out.println("Total Time (ms): " + totalTimeMillis);
        System.out.println("Formatted Time: " + formattedTime);
        System.out.println(stopWatch.prettyPrint());
    }
}