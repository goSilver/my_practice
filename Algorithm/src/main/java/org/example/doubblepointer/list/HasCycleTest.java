package org.example.doubblepointer.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 判断链表是否有环
 * 思路：快慢指针，每当慢指针 slow 前进一步，快指针 fast 就前进两步。
 *      如果 fast 最终能正常走到链表末尾，说明链表中没有环；如果 fast 走着走着竟然和 slow 相遇了，
 *      那肯定是 fast 在链表中转圈了，说明链表中含有环。
 */
public class HasCycleTest {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void hasCycleCase() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = l1.next;

        assert hasCycle(l1);
    }

    @Test
    public void hasNotCycleCase() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        assert !hasCycle(l1);
    }
}
