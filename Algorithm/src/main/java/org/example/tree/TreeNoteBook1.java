package org.example.tree;

import org.example.base.ListNode;
import org.example.base.TreeNode;

/**
 * 二叉树递归练习
 */
public class TreeNoteBook1 {

    /**
     * 递归一棵二叉树
     *
     * @param root 根节点
     */
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 递归遍历链表
     *
     * @param head 头节点
     */
    public void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        traverse(head.next);
    }

    /**
     * 递归遍历数组
     *
     * @param arr 数组
     * @param i   访问下标
     */
    public void traverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        traverse(arr, i + 1);
    }


}
