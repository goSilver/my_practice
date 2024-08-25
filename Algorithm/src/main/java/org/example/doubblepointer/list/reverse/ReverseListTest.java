package org.example.doubblepointer.list.reverse;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 反转链表
 */
public class ReverseListTest {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 三指针
        ListNode pre = null, cur = head, nxt = head.next;
        while (cur != null) {
            // 逐个反转
            cur.next = pre;
            // 更新指针
            pre = cur;
            cur = nxt;
            if (nxt != null)
                nxt = nxt.next;
        }
        // 返回反转后的头结点
        return pre;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null)
            return head;

        // 三指针
        ListNode pre = null, cur = head, nxt = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt.next != null)
                nxt = nxt.next;
            n--;
        }

        // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
        head.next = cur;
        // 此时的 pre 是反转后的头结点
        return pre;
    }

    @Test
    public void case1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode fromEnd = reverse(l1);
        assert fromEnd.val == 5;
    }

    @Test
    public void case2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode fromEnd2 = reverseN(l1, 2);
        assert fromEnd2.val == 2;
    }
}
