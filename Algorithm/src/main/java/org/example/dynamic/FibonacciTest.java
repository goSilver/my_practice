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
     * 带dp数组的，时间复杂度O(n)，空间复杂度O(n)
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

    /**
     * 自底向上的思路
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int fibUp(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 只记录n-1和n-2的数
     * 进一步优化空间复杂度为O(1)
     *
     * @param n
     * @return
     */
    public int fibTwoParam(int n) {
        if (n == 0) return 0;

        // 定义两个变量记录n-1、n-2
        int dp_i_1 = 1, dp_i_2 = 0;

        for (int i = 2; i <= n; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

    @Test
    public void case1() {
        int res1 = fib(20);
        int res2 = fibWithDp(20);
        int res3 = fibUp(20);
        int res4 = fibTwoParam(20);


        System.out.println("result1：" + res1);
        System.out.println("result2：" + res2);
        System.out.println("result3：" + res3);
        System.out.println("result4：" + res4);

        assert res2 == res1;
        assert res3 == res1;
        assert res4 == res1;
    }
}
