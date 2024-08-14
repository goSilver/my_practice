package org.example.doubblepointer.list;

import org.example.base.ListNode;
import org.junit.Test;

/**
 * 合并两个有序链表得到一个新的有序链表
 * 思路：双指针+遍历
 */
public class MergeTwoListsTest {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        // 双指针遍历
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        // 处理余下未遍历到的
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;

        return dummy.next;
    }

    @Test
    public void twoLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(l1, l2);
        assert "112344".equals(res.toString());
    }

    @Test
    public void allNullNode() {
        ListNode res = mergeTwoLists(null, null);
        assert res == null;
    }

    @Test
    public void onlyOneList() {
        ListNode res = mergeTwoLists(null, new ListNode(1));
        assert "1".equals(res.toString());
    }
}
