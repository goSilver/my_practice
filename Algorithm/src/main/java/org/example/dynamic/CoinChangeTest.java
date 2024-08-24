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

    @Test
    public void case1() {
        int[] coins = new int[]{1, 2, 5};
        int result = coinChange(coins, 11);
        System.out.println(result);
        assert result == 3;
    }
}
