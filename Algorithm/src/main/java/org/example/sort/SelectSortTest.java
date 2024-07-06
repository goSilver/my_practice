package org.example.sort;

import cn.hutool.json.JSONUtil;
import org.example.util.MyUtil;
import org.junit.Test;

/**
 * 选择排序
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 是否稳定：否
 *
 * @author chensh
 * @datetime 2024/6/23 4:39 PM
 */
public class SelectSortTest {

    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 找到后半部分数组最小元素
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    index = j;
                    min = arr[j];
                }
            }

            // 判断是否需要交换
            if (arr[i] <= arr[index]) continue;
            // 交换
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }


    @Test
    public void normalCase() {
        int[] arr = new int[]{5, 3, 4, 1, 2};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert MyUtil.isOrderAsc(afterSort);
    }

    @Test
    public void haveSameValueCase() {
        int[] arr = new int[]{5, 3, 3, 1, 2};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert MyUtil.isOrderAsc(afterSort);
    }

    @Test
    public void allSameValueCase() {
        int[] arr = new int[]{0, 0, 0, 0, 0};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert MyUtil.isOrderAsc(afterSort);
    }

    @Test
    public void onlyOneValueCase() {
        int[] arr = new int[]{0};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert MyUtil.isOrderAsc(afterSort);
    }

    @Test
    public void alreadySortedCase() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] afterSort = sort(arr);
        System.out.println(JSONUtil.toJsonStr(afterSort));
        assert MyUtil.isOrderAsc(afterSort);
    }
}
