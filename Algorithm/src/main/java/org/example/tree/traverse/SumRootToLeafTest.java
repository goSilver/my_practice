package org.example.tree.traverse;

import org.example.base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 从根到叶的二进制数之和
 */
public class SumRootToLeafTest {
    private int result;
    public void sumRootToLeaf(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        traverse(root, list);
    }

    public void traverse(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return;

        // 记录访问元素
        list.add(root.getVal());

        // 到达叶子节点，转换为十进制并累加
        if (root.getLeft() == null && root.getRight() == null) {
            int cur = 0;
            for (int i = 0; i < list.size(); i++) {
                cur += list.get(i) * Math.pow(2, list.size() - i - 1);
            }
            result += cur;
        }

        // 遍历
        traverse(root.getLeft(), list);
        traverse(root.getRight(), list);

        // 删除已访问过元素
        list.removeLast();
    }


    @Test
    public void case1() {
        /*
             1
           /   \
          0     1
         / \   /  \
        0   1 0    1
         */
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(0));
        root.setRight(new TreeNode(1));
        root.getLeft().setLeft(new TreeNode(0));
        root.getLeft().setRight(new TreeNode(1));
        root.getRight().setLeft(new TreeNode(0));
        root.getRight().setRight(new TreeNode(1));
        sumRootToLeaf(root);
        System.out.println(result);
        assert 22 == result;
    }

    @Test
    public void case2() {
        /*
             0
         */
        TreeNode root = new TreeNode(0);
        sumRootToLeaf(root);
        System.out.println(result);
        assert 0 == result;
    }
}
