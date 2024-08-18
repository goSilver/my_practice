package org.example.tree;

import org.example.base.TreeNode;
import org.junit.Test;

/**
 * 二叉树的最大深度
 */
public class MaxDepthTest {
    private int maxDepth;
    private int depth;

    private void maxDepth(TreeNode root) {
        if (root == null)
            return;
        depth++;
        // 到达叶子节点才更新res
        if (root.getLeft() == null && root.getRight() == null)
            maxDepth = Math.max(maxDepth, depth);
        maxDepth(root.getLeft());
        maxDepth(root.getRight());
        depth--;
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
        maxDepth(root);
        assert 4 == res;
    }
}
