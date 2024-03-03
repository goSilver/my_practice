package org.example.concurrent.part1;

/**
 * @author chensh
 * @datetime 2024/3/3 7:46 PM
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("RunnableTest.run()");
    }
}
 class Main{
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
    }
}
