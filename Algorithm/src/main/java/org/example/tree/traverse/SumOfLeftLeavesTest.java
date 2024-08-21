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
        if (isLeft && root.getLeft() == null && root.getRight() == null) {
            result += root.getVal();
        }

        traverse(root.getLeft(), true);
        traverse(root.getRight(), false);
    }

    @Test
    public void case1() {
        /*
              3
           /    \
          9      20
                /  \
               15   17

         result：1026
         */
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(17));
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

         result：1026
         */
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(0));
        root.getLeft().setLeft(new TreeNode(5));
        root.getLeft().setRight(new TreeNode(1));
        sumOfLeftLeaves(root);
        System.out.println(result);
        assert result == 5;
    }
}
