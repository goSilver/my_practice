package org.example.doubblepointer.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 寻找两个链表交点
 * 思路：两个指针交替遍历两个链表，相遇时即是交点
 */
public class GetIntersectionNodeTest {

    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = l2;
            }

            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = l1;
            }
        }
        return p1;
    }

    @Test
    public void case1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(-1);
        l2.next = new ListNode(-2);
        l2.next.next = new ListNode(-3);
        l2.next.next.next = l1.next.next.next;

        ListNode fromEnd = getIntersectionNode(l1, l2);
        assert fromEnd.val == 4;
    }

    @Test
    public void noIntersectionCase() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(-1);
        l2.next = new ListNode(-2);

        ListNode fromEnd = getIntersectionNode(l1, l2);
        assert fromEnd == null;
    }
}
