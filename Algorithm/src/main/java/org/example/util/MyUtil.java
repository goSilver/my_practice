package org.example.util;

import org.example.base.ListNode;

/**
 * @author chensh
 * @datetime 2024/6/23 3:58 PM
 */
public class MyUtil {

    /**
     * 判断数组是否升序
     *
     * @param arr 数组
     * @return 是否升序
     */
    public static boolean isOrderAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断链表表示的值是否等于数组
     *
     * @param expectResult 期望值的数组形式
     * @param head         链表形式的数
     * @return 是否相等
     */
    public static boolean verifyResult(int[] expectResult, ListNode head) {
        if (head == null && expectResult.length > 0) return false;
        int index = 0;
        while (head != null) {
            System.out.print(head.val);
            if (head.val != expectResult[index]) return false;
            index++;
            head = head.next;
        }
        if (index != expectResult.length) return false;
        return true;
    }
}
