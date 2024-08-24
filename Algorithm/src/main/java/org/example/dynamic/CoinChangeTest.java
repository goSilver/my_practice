package org.example.dynamic;

import org.junit.Test;

import java.util.Arrays;

/**
 * 凑零钱问题
 */
public class CoinChangeTest {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        // 备忘录，防止重复计算
        if (memo[amount] != -666)
            return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解，跳过
            if (subProblem == -1) continue;
            // 在子问题中寻找最优解，然后+1
            res = Math.min(res, subProblem + 1);
        }

        // 把计算结果放回备忘录
        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return memo[amount];
    }

    /**
     * 自底向上的思路
     *
     * @param coins
     * @param amount
     * @return
     */
    public int dpWithUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i -coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    @Test
    public void case1() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int result1 = coinChange(coins, amount);
        System.out.println(result1);
        int result2 = dpWithUp(coins, amount);
        System.out.println(result2);
        assert result1 == 3;
        assert result2 == 3;
    }
}
