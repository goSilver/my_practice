package org.example.dynamic;

import org.junit.Test;

/**
 * 凑零钱问题
 */
public class CoinChangeTest {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解，跳过
            if (subProblem == -1) continue;
            // 在子问题中寻找最优解，然后+1
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    @Test
    public void case1() {
        int[] coins = new int[]{1,2,5};
        int result = coinChange(coins, 11);
        System.out.println(result);
        assert result == 3;
    }
}
