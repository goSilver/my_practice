package org.example.doubblepointer.array;

import org.junit.Test;

/**
 * 原地删除数组指定元素
 * 思路：快慢指针
 */
public class RemoveElementTest {
    public int removeElement(int[] arr, int n) {
        int slow = 0, fast = 0;
        while (fast < arr.length) {
            if (arr[fast] != n) {
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void case1() {
        int[] arr = new int[]{3, 2, 2, 3};
        assert 2 == removeElement(arr, 3);
    }

    @Test
    public void case2() {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        assert 5 == removeElement(arr, 2);
    }
}
