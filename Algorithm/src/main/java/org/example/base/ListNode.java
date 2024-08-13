package org.example.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 从当前节点打印链表
     *
     * @return 字符串
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            res.append(head.val);
            head = head.next;
        }
        return res.toString();
    }
}