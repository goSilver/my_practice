package org.example.c.structural.b.template;

/**
 * JVM停机钩子示例
 *
 * @author goku
 * @datetime 2023/8/7 10:17 PM
 */
public class ShutdownHookDemo {

    private static class ShutdownHook extends Thread {
        public void run() {
            System.out.println("I am called during shutting down.");
        }
    }

    public static void main(String[] args) {
        // 注册关闭钩子
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }

}
