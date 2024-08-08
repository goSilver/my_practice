package org.example.leetcode;

import org.junit.Test;

/**
 * 股票买卖I
 * 思路：以卖出价往前查最低买入价，即可得到最大利润
 * 实现：遍历过程中找到最低买入价，往后继续遍历计算最大利润
 * 时间复杂度：O(n)
 */
public class A121MaxProfitITest {

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    @Test
    public void case1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        assert 5 == maxProfit(prices);
    }

    @Test
    public void case2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        assert 0 == maxProfit(prices);
    }

    @Test
    public void case3() {
        int[] prices = new int[]{5, 1, 7, 0, 5};
        assert 6 == maxProfit(prices);
    }
}
