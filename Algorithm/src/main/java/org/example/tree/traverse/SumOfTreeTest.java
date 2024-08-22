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
        cur = cur * 10 + root.val;

        // 如果是叶子节点，累加到result
        if (root.left == null && root.right == null)
            result += cur;

        traverse(root.left);
        traverse(root.right);

        // 退出节点时，减法
        cur = (cur - root.val) / 10;
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
        root.left = (new TreeNode(2));
        root.right = (new TreeNode(5));
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
        root.left = (new TreeNode(9));
        root.right = (new TreeNode(0));
        root.left.left = (new TreeNode(5));
        root.left.right = (new TreeNode(1));
        int result = sumOfTree(root);
        assert result == 1026;
        System.out.println(result);
    }
}
