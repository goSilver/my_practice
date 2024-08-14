package org.example.doubblepointer.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 寻找链表中点
 * 思路：快慢指针，p1一次走一步，p2一次走两步
 */
public class FindMiddleNodeTest {
    public ListNode findMiddleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    @Test
    public void oddNodes() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        assert 3 == findMiddleNode(l1).val;
    }

    @Test
    public void evenNodes() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        assert 3 == findMiddleNode(l1).val;
    }
}
