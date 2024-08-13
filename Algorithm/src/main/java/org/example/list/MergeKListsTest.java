package org.example.list;

import org.example.base.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * 合并K个有序列表
 *
 * 思路：利用优先级队列，每次从队列中取出最小元素拼接在链表后面
 *
 * 时间复杂度：
 * 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；
 * 所有的链表节点都会被加入和弹出 pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。
 */
public class MergeKListsTest {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        // 定义最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.size(), Comparator.comparingInt(a -> a.val)
        );

        // 将所有头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                queue.add(head);
        }

        // 一直将最小堆堆顶元素poll，并拼接在链表末尾
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null)
                queue.offer(node.next);

            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }

    @Test
    public void threeLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode res = mergeKLists(Arrays.asList(l1,l2,l3));
        assert "11234456".equals(res.toString());
    }

    @Test
    public void emptyList1() {
        ListNode res = mergeKLists(Collections.emptyList());
        assert null == res;
    }

    @Test
    public void emptyList2() {
        ListNode res = mergeKLists(Collections.singletonList(new ListNode()));
        assert "0".equals(res.toString());
    }
}
