package org.example.tree;

import cn.hutool.json.JSONUtil;
import org.example.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 思路：借助队列结构，遍历每一层时，将下一层的子节点存入队列中，一直遍历到队列为空
 */
public class TreeLevelOrderTest {
    List<Integer> levelOrder = new ArrayList<>();
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            levelOrder.add(cur.val);

            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
    }

    @Test
    public void case1() {
         /*
            1
           / \
          2   3
         /   / \
        4   5   6
         */
        TreeNode root = new TreeNode(1);
        root.left = (new TreeNode(2));
        root.right = (new TreeNode(3));
        root.left.left = (new TreeNode(4));
        root.right.left = (new TreeNode(5));
        root.right.right = (new TreeNode(6));
        levelOrder(root);
        assert "[1,2,3,4,5,6]".equals(JSONUtil.toJsonStr(levelOrder));
        System.out.println("层序遍历：" + JSONUtil.toJsonStr(levelOrder));
    }
}
