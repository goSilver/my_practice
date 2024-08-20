package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 最接近的二叉搜索树值
 */
public class ClosestValueTest {
    private int result;

    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return result;
    }

    public void traverse(TreeNode root, double target) {
        if (root == null) return;

        // 当差值更小时，更新result
        if (Math.abs(root.getVal() - target) < Math.abs(result - target)) {
            result = root.getVal();
        }

        traverse(root.getLeft(), target);
        traverse(root.getRight(), target);
    }

    @Test
    public void case1() {
        /*
             4
           /   \
          2     5
         / \
        1   3
         */
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(5));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(3));
        int result = closestValue(root, 3.7);
        assert result == 4;
        System.out.println(result);
    }

    @Test
    public void case2() {
        /*
             4
         */
        TreeNode root = new TreeNode(4);
        int result = closestValue(root, 3.7);
        assert result == 4;
        System.out.println(result);
    }
}
