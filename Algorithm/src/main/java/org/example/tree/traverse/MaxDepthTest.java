package org.example.tree.traverse;

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
        if (root.left == null && root.right == null)
            maxDepth = Math.max(maxDepth, depth);
        maxDepth(root.left);
        maxDepth(root.right);
        depth--;
    }

    /**
     * 分解思路，一棵二叉树的最大深度可以通过子树的最大深度推导出
     */
    private int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
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
        root.left = (new TreeNode(2));
        root.right = (new TreeNode(5));
        root.left.left = (new TreeNode(3));
        root.left.right = (new TreeNode(4));
        root.right.left = (new TreeNode(6));
        root.right.left.left = (new TreeNode(7));
//        maxDepth(root);
        maxDepth2(root);
        assert 4 == maxDepth;
    }
}
