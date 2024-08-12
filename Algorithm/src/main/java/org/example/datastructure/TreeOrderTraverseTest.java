package org.example.datastructure;

import cn.hutool.json.JSONUtil;
import org.example.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前中后序遍历
 * 思路：递归
 */
public class TreeOrderTraverseTest {
    List<Integer> preOrder = new ArrayList<>();
    List<Integer> midOrder = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();

    public void traverse(TreeNode root) {
        if (root == null)
            return;

        // 前序遍历结果集
        preOrder.add(root.getVal());
        traverse(root.getLeft());
        // 中序遍历结果集
        midOrder.add(root.getVal());
        traverse(root.getRight());
        // 后序遍历结果集
        postOrder.add(root.getVal());
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
        traverse(root);
        System.out.println("前序遍历：" + JSONUtil.toJsonStr(preOrder));
        System.out.println("中序遍历：" + JSONUtil.toJsonStr(midOrder));
        System.out.println("后序遍历：" + JSONUtil.toJsonStr(postOrder));
    }
}
