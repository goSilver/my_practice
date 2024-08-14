package org.example.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 寻找倒数第k个节点
 * 思路：双指针，p2先走k步，p1再开始走，当p2走到末尾时p1即在倒数第k
 */
public class FindFromEndTest {
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        while (p2 != null) {
            p2 = p2.next;

            // p2先走k步，p1再开始走
            if (k > 0) {
                k--;
            } else {
                p1 = p1.next;
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

        ListNode fromEnd = findFromEnd(l1, 2);
        assert fromEnd.val == 4;
    }

    @Test
    public void biggerK() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode fromEnd = findFromEnd(l1, 4);
        assert fromEnd.val == 1;
    }

    @Test
    public void nullList() {
        ListNode fromEnd = findFromEnd(null, 4);
        assert null == fromEnd;
    }

}
