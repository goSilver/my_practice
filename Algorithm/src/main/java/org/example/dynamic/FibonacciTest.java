package org.example.dynamic;

import org.junit.Test;

/**
 * 斐波那契数列
 */
public class FibonacciTest {

    /**
     * 普通实现，时间复杂度O(2n)，指数级
     *
     * @param N n
     * @return fib
     */
    private int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 带dp数组的，时间复杂度O(n)
     *
     * @param n n
     * @return fib
     */
    public int fibWithDp(int n) {
        int[] dp = new int[n + 1];
        return dp(dp, n);
    }

    public int dp(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;

        // 如果已经算过了，直接return结果
        if (memo[n] != 0) {
            return memo[n];
        }

        // 递归
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    @Test
    public void case1() {
        int res1 = fib(20);
        int res2 = fibWithDp(20);
        System.out.println("result1：" + res1);
        System.out.println("result2：" + res2);
        assert res2 == res1;
    }
}
