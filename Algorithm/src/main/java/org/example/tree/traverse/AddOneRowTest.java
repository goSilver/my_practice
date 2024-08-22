package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.example.util.TreeUtil;
import org.junit.Test;

/**
 * 在二叉树中增加一行
 */
public class AddOneRowTest {

    private int depth;
    private int val;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.depth = depth;
        this.val = val;
        if (depth == 0) return root;
        // 当depth=1时特殊处理
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
          if (root == null) return;
          depth--;

          // 到达目标层级，生成新节点并拼接
          if (depth == 1) {
              TreeNode newLeft = new TreeNode(val);
              newLeft.left = root.left;
              root.left = newLeft;

              TreeNode newRight = new TreeNode(val);
              newRight.right = root.right;
              root.right = newRight;

              // 优化：提前return，不做多余递归
              depth++;
              return;
          }

          traverse(root.left);
          traverse(root.right);

          depth++;
    }

    @Test
    public void case1() {
        /*
             4
           /   \
          2     6
         / \   /
        3   1 5
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println("before：");
        TreeUtil.print(root);
        TreeNode res = addOneRow(root, 1, 2);
        System.out.println("after：");
        TreeUtil.print(res);
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
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        TreeNode res = addOneRow(root, 8, 2);
        TreeUtil.print(res);
    }

}
