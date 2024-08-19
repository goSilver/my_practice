package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 求根节点到叶节点数字之和
 */
public class SumOfTreeTest {
    private int result;
    private int cur;
    private int sumOfTree(TreeNode root) {
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        // 累加
        cur = cur * 10 + root.getVal();

        // 如果是叶子节点，累加到result
        if (root.getLeft() == null && root.getRight() == null)
            result += cur;

        traverse(root.getLeft());
        traverse(root.getRight());

        // 退出节点时，减法
        cur = (cur - root.getVal()) / 10;
    }

    @Test
    public void case1() {
        /*
             1
           /   \
          2     5

         result：27
         */
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(5));
        int result = sumOfTree(root);
        assert result == 27;
        System.out.println(result);
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
        int result = sumOfTree(root);
        assert result == 1026;
        System.out.println(result);
    }
}
