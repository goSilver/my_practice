package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 二叉树最长连续序列
 */
public class LongestConsecutiveTest {
    private  int maxLen;
    public int longestConsecutive(TreeNode root ) {
        traverse(root, 1 , Integer.MIN_VALUE);
        return maxLen;
    }

    public void traverse(TreeNode root, int len, int parentVal) {
        if (root == null) return;

        if (root.val == parentVal + 1) {
            len++;
        } else {
            len = 1;
        }

        maxLen = Math.max(maxLen, len);

        traverse(root.left, len, root.val);
        traverse(root.right, len, root.val);
    }

    @Test
    public void case1() {
        /*
             4
           /   \
          9     5
               /
              7
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        int res = longestConsecutive(root);
        System.out.println(res);
        assert 2 == res;
    }

    @Test
    public void case2() {
        /*
             4
           /   \
          9     5
               / \
              7   6
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        int res = longestConsecutive(root);
        System.out.println(res);
        assert 3 == res;
    }
}
