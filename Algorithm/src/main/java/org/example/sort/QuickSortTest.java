package org.example.sort;

import cn.hutool.json.JSONUtil;
import org.example.util.OrderUtil;
import org.junit.Test;

/**
 * 快速排序
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 是否稳定：否
 *
 * @author chensh
 * @datetime 2024/6/25 7:29 PM
 */
public class QuickSortTest {

    int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int middle = partition(arr, start, end);
        quickSort(arr, start, middle - 1);
        quickSort(arr, middle+1, end);
    }

    int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start+1;
        int right = end;

        while (left < right) {
            while (left < right && arr[left] <= pivot) left++;
            if (left != right) {
                exchange(arr, left, right);
                right--;
            }
        }

        if (left == right && arr[right] > pivot) right--;
        // 将基数和中间数交换
        if (right != start) exchange(arr, start, right);
        return right;

    }

    void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

