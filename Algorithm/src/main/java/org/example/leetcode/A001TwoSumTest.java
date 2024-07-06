package org.example.leetcode;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 利用字典的辅助
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class A001TwoSumTest {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{i, numMap.get(target - nums[i])};
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void normalCase() {
        int[] nums = new int[]{2,7,11,15};
        int target  =  9;
        int[] exceptResult = new int[]{0,1};
        int[] res = twoSum(nums, target);
        System.out.println(JSONUtil.toJsonStr(res));
        assert Arrays.equals(exceptResult, res);
    }
}
