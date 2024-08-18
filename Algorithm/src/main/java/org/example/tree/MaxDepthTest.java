package org.example.tree;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 二叉树的最大深度
 */
public class MaxDepthTest {
    private int maxDepth;
    private int depth;

    /**
     * 遍历方式求解思路
     */
    private void maxDepth(TreeNode root) {
        if (root == null) return;
        depth++;
        // 到达叶子节点才更新res
        if (root.getLeft() == null && root.getRight() == null)
            maxDepth = Math.max(maxDepth, depth);
        maxDepth(root.getLeft());
        maxDepth(root.getRight());
        depth--;
    }

    /**
     * 分解思路，一棵二叉树的最大深度可以通过子树的最大深度推导出
     */
    private int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth2(root.getLeft());
        int right = maxDepth2(root.getRight());
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        maxDepth = Math.max(left, right) + 1;
        return maxDepth;
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
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(5));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().getLeft().setLeft(new TreeNode(7));
//        maxDepth(root);
        maxDepth2(root);
        assert 4 == maxDepth;
    }
}
