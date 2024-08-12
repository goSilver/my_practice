package org.example.datastructure;

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
            levelOrder.add(cur.getVal());

            if (cur.getLeft() != null)
                queue.offer(cur.getLeft());
            if (cur.getRight() != null)
                queue.offer(cur.getRight());
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
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().setRight(new TreeNode(6));
        levelOrder(root);
        assert "[1,2,3,4,5,6]".equals(JSONUtil.toJsonStr(levelOrder));
        System.out.println("层序遍历：" + JSONUtil.toJsonStr(levelOrder));
    }
}
