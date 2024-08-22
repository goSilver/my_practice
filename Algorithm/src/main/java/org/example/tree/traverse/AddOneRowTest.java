package org.example.tree.traverse;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;
import org.junit.Test;

public class AddOneRowTest {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        traverse(root, val, depth, false);
        return root;
    }

    public void traverse(TreeNode root, int val, int depth, boolean isLeft) {
          if (root == null) return;
          depth--;

          if (depth == 0) {
              TreeNode newNode = new TreeNode(val, root.left, root.right);
              if (isLeft) {
                  root.left = newNode;
              } else {
                  root.right = newNode;
              }
              return;
          }

          traverse(root.left, val, depth, true);
          traverse(root.right, val, depth, false);

          depth++;
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
        addOneRow(root, 1, 2);
        TreeUtil.print(root);
    }

}
