package org.example.doubblepointer.array;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

/**
 * 移动0到数组末尾
 */
public class MoveZeroTest {
    public void moveZero(int[] arr) {
        int slow = 0, fast = 0;
        while (fast < arr.length) {
            if (arr[fast] != 0) {
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow; i <arr.length; i++) {
            arr[i] = 0;
        }
    }

    @Test
    public void case1() {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        moveZero(arr);
        assert "[1,2,2,3,4,2,0,0]".equals(JSONUtil.toJsonStr(arr));
        System.out.println(JSONUtil.toJsonStr(arr));
    }

}
