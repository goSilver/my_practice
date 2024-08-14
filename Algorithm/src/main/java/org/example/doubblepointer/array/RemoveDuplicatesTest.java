package org.example.doubblepointer.array;

import org.junit.Test;

/**
 * 删除有序数组中的重复项
 */
public class RemoveDuplicatesTest {
    public int removeDuplicate(int[] arr) {
        if (arr.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < arr.length) {
            if (arr[slow] != arr[fast]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                arr[slow] = arr[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }

    @Test
    public void case1() {
        int[] arr = new int[]{1, 1, 2};
        assert removeDuplicate(arr) == 2;
    }

    @Test
    public void case2() {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assert removeDuplicate(arr) == 5;
    }
}
