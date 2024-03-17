package org.example.concurrent.test;

/**
 * 题目：
 * 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
 *
 * @author chensh
 * @datetime 2024/3/17 1:06 PM
 */
public class Test5 {
    private int finalResult;

    private void add(int times) {
        // 得出本轮计算的始末数字
        int begin = 10 * times +1;
        int end = begin + 10;
        // 记录本轮的结算之和
        int curResult = 0;
        for (int i = begin; i < end; i++) {
            curResult += i;
        }
        // 将本轮计算之和累加到finalResult
        finalResult += curResult;
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        // 开启10个线程进行累加
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> test5.add(finalI)).start();
        }
        System.out.println("finalResult=" + test5.finalResult);
    }
}
