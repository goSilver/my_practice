package org.example.sort;

import cn.hutool.json.JSONUtil;
import org.example.util.MyUtil;
import org.junit.Test;

/**
 * 插入排序
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 是否稳定：是
 *
 * @author chensh
 * @datetime 2024/6/23 4:21 PM
 */
public class InsertSortTest {

    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
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
