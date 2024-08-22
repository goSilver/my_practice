package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 左叶子之和
 */
public class SumOfLeftLeavesTest {
    private  int result;

    public void sumOfLeftLeaves(TreeNode root) {
        traverse(root, false);
    }

    public void traverse(TreeNode root, boolean isLeft) {
        if (root == null) return;

        // 判断是否左叶子节点
        if (isLeft && root.left == null && root.right == null) {
            result += root.val;
        }

        traverse(root.left, true);
        traverse(root.right, false);
    }

    @Test
    public void case1() {
        /*
              3
            /   \
           9     20
                /  \
               15   17
         */
        TreeNode root = new TreeNode(3);
        root.left = (new TreeNode(9));
        root.right = (new TreeNode(20));
        root.right.left = (new TreeNode(15));
        root.right.right = (new TreeNode(17));
        sumOfLeftLeaves(root);
        System.out.println(result);
        assert result == 24;
    }

    @Test
    public void case2() {
        /*
             4
           /   \
          0     0
         / \
        5   1
         */
        TreeNode root = new TreeNode(4);
        root.left = (new TreeNode(9));
        root.right = (new TreeNode(0));
        root.left.left = (new TreeNode(5));
        root.left.right = (new TreeNode(1));
        sumOfLeftLeaves(root);
        System.out.println(result);
        assert result == 5;
    }
}
