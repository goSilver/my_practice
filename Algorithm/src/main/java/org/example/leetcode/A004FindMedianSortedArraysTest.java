package org.example.leetcode;

import org.junit.Test;

/**
 * 寻找两个正序数组的中位数
 */
public class A004FindMedianSortedArraysTest {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1;
        int right = -1;
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }

        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    @Test
    public void case1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double res = findMedianSortedArrays(nums1, nums2);
        assert res == 2;
    }

    @Test
    public void case2() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        assert res == 2.5;
    }

    @Test
    public void allZero() {
        int[] nums1 = new int[]{0, 0};
        int[] nums2 = new int[]{0, 0};
        double res = findMedianSortedArrays(nums1, nums2);
        assert res == 0;
    }
}
