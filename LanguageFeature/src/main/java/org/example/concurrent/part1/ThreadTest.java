package org.example.concurrent.part1;

/**
 * @author chensh
 * @datetime 2024/3/3 7:53 PM
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadTest.run()");
    }
}

class Main2 {
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        tt.start();
    }
}
