package org.example.sort;

import cn.hutool.json.JSONUtil;
import org.example.util.OrderUtil;
import org.junit.Test;

/**
 * 冒泡排序
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 是否稳定：是
 *
 * @author chensh
 * @datetime 2024/6/23 3:27 PM
 */
public class BubbleSortTest {

    int[] sort(int[] arr) {
        if (arr.length <= 1) return arr;

        for (int i = 0; i < arr.length; i++) {
            // 提前退出冒泡的标志位
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换数据
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 无数据交换则表示数组已经有序
            if (!flag) break;
        }
        return arr;
    }

    @Test
    public void normalCase() {
        int[] arr = new int[]{5, 3, 4, 1, 2};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert OrderUtil.isOrderAsc(afterSort);
    }

    @Test
    public void haveSameValueCase() {
        int[] arr = new int[]{5, 3, 3, 1, 2};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert OrderUtil.isOrderAsc(afterSort);
    }

    @Test
    public void allSameValueCase() {
        int[] arr = new int[]{0, 0, 0, 0, 0};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert OrderUtil.isOrderAsc(afterSort);
    }

    @Test
    public void onlyOneValueCase() {
        int[] arr = new int[]{0};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert OrderUtil.isOrderAsc(afterSort);
    }

    @Test
    public void alreadySortedCase() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert OrderUtil.isOrderAsc(afterSort);
    }
}
