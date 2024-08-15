package org.example.doubblepointer.array;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

/**
 * 两数之和，有序数组版
 */
public class TwoSumTest {
    public int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void case1() {
        int[] arr = new int[]{2,7,11,15};
        String jsonStr = JSONUtil.toJsonStr(twoSum(arr, 9));
        System.out.println(jsonStr);
        assert "[0,1]".equals(jsonStr);
    }

    @Test
    public void case2() {
        int[] arr = new int[]{2,3,4};
        String jsonStr = JSONUtil.toJsonStr(twoSum(arr, 6));
        System.out.println(jsonStr);
        assert "[0,2]".equals(jsonStr);
    }

    @Test
    public void case3() {
        int[] arr = new int[]{0,-1};
        String jsonStr = JSONUtil.toJsonStr(twoSum(arr, -1));
        System.out.println(jsonStr);
        assert "[0,1]".equals(jsonStr);
    }
}
