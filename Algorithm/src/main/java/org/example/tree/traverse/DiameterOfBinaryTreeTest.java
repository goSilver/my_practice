package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 计算二叉树的最大直径
 */
public class DiameterOfBinaryTreeTest {
    private int maxRes;
    private int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        // 后序位置，计算最大直径
        maxRes = Math.max(maxRes, left + right);
        return Math.max(left, right) + 1;
    }

    @Test
    public void case1() {
        /*
                1
           /       \
          2         5
         / \       /
        3   4     6
                 /
                7
         */
        TreeNode root = new TreeNode(1);
        root.left = (new TreeNode(2));
        root.right = (new TreeNode(5));
        root.left.left = (new TreeNode(3));
        root.left.right = (new TreeNode(4));
        root.right.left = (new TreeNode(6));
        root.right.left.left = (new TreeNode(7));
        diameterOfBinaryTree(root);
        assert 5 == maxRes;
    }
}
