package org.example.doubblepointer.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 分隔链表：
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 思路：把原链表分成两个小链表，一个链表中的元素大小都小于 x，另一个链表中的元素都大于等于 x，最后再把这两条链表接到一起
 */
public class PartitionListTest {
    public ListNode partition(ListNode head, int n) {
        // 两个虚拟头节点，分别用于记录大于n的节点列表和小于n的节点列表
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;

        while (p != null) {
            if (p.val >= n) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 断开原链表中的每个节点的 next 指针
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    @Test
    public void normalCase() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        ListNode res = partition(l1, 3);
        System.out.println(res.toString());
        assert "122435".equals(res.toString());
    }

    @Test
    public void allNull() {
        ListNode res = partition(null, 3);
        assert null == res;
    }

    @Test
    public void allSmallerThan() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        ListNode res = partition(l1, 9);
        System.out.println(res.toString());
        assert "143252".equals(res.toString());
    }

    @Test
    public void allBiggerThan() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        ListNode res = partition(l1, 0);
        System.out.println(res.toString());
        assert "143252".equals(res.toString());
    }
}
