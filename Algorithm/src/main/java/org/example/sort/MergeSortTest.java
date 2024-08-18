package org.example.sort;

import cn.hutool.json.JSONUtil;
import org.example.util.MyUtil;
import org.junit.Test;

/**
 * 时间复杂度：O(nlogn)
 * @author chensh
 * @datetime 2024/6/25 5:13 PM
 */
public class MergeSortTest {

    int[] sort(int[] arr) {
        if(arr.length <= 1) return arr;
        int[] result = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, result);
        return result;
    }

    void mergeSort(int[] arr, int start, int end, int[] result) {
        // 只剩下一个数字，停止拆分
        if (start == end) return;
        int middle = (start + end) / 2;
        // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间
        mergeSort(arr, start, middle, result);
        // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间
        mergeSort(arr, middle + 1, end, result);
        // 合并左右区域到 result 的 [start, end] 区间
        merge(arr, start, end, result);
    }

    void merge(int[] arr, int start, int end, int[] result) {
        int end1 = (start + end) / 2;
        int start2 = end1 + 1;
        // 用来遍历数组的指针
        int index1 = start;
        int index2 = start2;
        while (index1 <= end1 && index2 <= end) {
            if (arr[index1] <= arr[index2]) {
                result[index1 + index2 - start2] = arr[index1++];
            } else {
                result[index1 + index2 - start2] = arr[index2++];
            }
        }
        // 将剩余数字补到结果数组之后
        while (index1 <= end1) {
            result[index1 + index2 - start2] = arr[index1++];
        }
        while (index2 <= end) {
            result[index1 + index2 - start2] = arr[index2++];
        }
        // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
        while (start <= end) {
            arr[start] = result[start++];
        }
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
