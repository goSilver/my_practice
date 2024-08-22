package org.example.tree;

import cn.hutool.json.JSONUtil;
import org.example.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前中后序遍历
 * 思路：递归（DFS）
 */
public class TreeOrderTraverseTest {
    List<Integer> preOrder = new ArrayList<>();
    List<Integer> midOrder = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();

    public void traverse(TreeNode root) {
        if (root == null)
            return;

        // 前序遍历结果集
        preOrder.add(root.val);
        traverse(root.left);
        // 中序遍历结果集
        midOrder.add(root.val);
        traverse(root.right);
        // 后序遍历结果集
        postOrder.add(root.val);
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
        traverse(root);
        System.out.println("前序遍历：" + JSONUtil.toJsonStr(preOrder));
        System.out.println("中序遍历：" + JSONUtil.toJsonStr(midOrder));
        System.out.println("后序遍历：" + JSONUtil.toJsonStr(postOrder));
    }

    @Test
    public void case2() {
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
        traverse(root);
        System.out.println("前序遍历：" + JSONUtil.toJsonStr(preOrder));
        System.out.println("中序遍历：" + JSONUtil.toJsonStr(midOrder));
        System.out.println("后序遍历：" + JSONUtil.toJsonStr(postOrder));
    }
}
