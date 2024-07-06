package org.example.leetcode;

import org.example.base.ListNode;
import org.junit.Test;

import java.util.Objects;

import static org.example.util.MyUtil.verifyResult;

/**
 * 两数之和
 * 执行两个链表的加法
 * 时间复杂度：O(max(m,n))
 * 空间复杂度：O(1)
 */
public class A002AddTwoNumbersTest {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) && Objects.isNull(l2)) return null;

        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;

            int sum = l1Num + l2Num + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = node;

            if (Objects.nonNull(l1)) l1 = l1.next;
            if (Objects.nonNull(l2)) l2 = l2.next;
        }

        // 处理最后剩下的进位值
        if (carry > 0) cur.next = new ListNode(carry);
        return head.next;
    }


    @Test
    public void normalCase() {
        // 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
        ListNode l1 = new ListNode(2);
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(3);
        l1.next = one;
        one.next = two;

        ListNode l2 = new ListNode(5);
        ListNode three = new ListNode(6);
        ListNode four = new ListNode(4);
        l2.next = three;
        three.next = four;

        ListNode listNode = addTwoNumbers(l1, l2);
        assert verifyResult(new int[]{7, 0, 8}, listNode);
    }

    @Test
    public void twoZeroCase() {
        // 输入：l1 = [0], l2 = [0] 输出：[0]
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode listNode = addTwoNumbers(l1, l2);
        assert verifyResult(new int[]{0}, listNode);
    }

    @Test
    public void allNineCase() {
        // 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);l1.next = l12;
        ListNode l13 = new ListNode(9);l12.next = l13;
        ListNode l14 = new ListNode(9);l13.next = l14;
        ListNode l15 = new ListNode(9);l14.next = l15;
        ListNode l16 = new ListNode(9);l15.next = l16;
        ListNode l17 = new ListNode(9);l16.next = l17;

        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);l2.next = l22;
        ListNode l23 = new ListNode(9);l22.next = l23;
        ListNode l24 = new ListNode(9);l23.next = l24;
        ListNode listNode = addTwoNumbers(l1, l2);
        assert verifyResult(new int[]{8,9,9,9,0,0,0,1}, listNode);
    }

}
