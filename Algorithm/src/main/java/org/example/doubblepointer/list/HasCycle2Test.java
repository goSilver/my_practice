package org.example.doubblepointer.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 寻找环形链表的起点
 * 思路：当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。
 */
public class HasCycle2Test {
    public ListNode findCycleBegin(ListNode head) {
        ListNode fast = head, slow = head;
        // 快慢指针相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        slow = head;
        // 同步前进，再次相遇即是环形起点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (slow == fast)
                return slow;
        }
        return null;
    }

    @Test
    public void hasCycleCase() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = l1.next;

        assert 2 == findCycleBegin(l1).val;
    }

    @Test
    public void hasNotCycleCase() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        assert null == findCycleBegin(l1);
    }
}
