package org.example.tree.traverse;

import cn.hutool.json.JSONUtil;
import org.example.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右侧视图
 */
public class RightSideViewTest {
    private List<Integer> result = new ArrayList<>();
    private int depth;

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;

        depth++;
        if (depth > result.size())
            result.add(root.val);

        // 注意：此处先遍历右子树
        traverse(root.right);
        traverse(root.left);
        depth--;

    }

    @Test
    public void case1() {
        /*
             4
           /   \
          9     0
         / \
        5   1
         */
        TreeNode root = new TreeNode(4);
        root.left = (new TreeNode(9));
        root.right = (new TreeNode(0));
        root.left.left = (new TreeNode(5));
        root.left.right = (new TreeNode(1));
        List<Integer> res = rightSideView(root);
        System.out.println(res);
        assert "[4,0,1]".equals(JSONUtil.toJsonStr(res));
    }

    @Test
    public void case2() {
        /*
             4
           /   \
          9     0
               /
              5
         */
        TreeNode root = new TreeNode(4);
        root.left = (new TreeNode(9));
        root.right = (new TreeNode(0));
        root.right.left = (new TreeNode(5));
        List<Integer> res = rightSideView(root);
        System.out.println(res);
        assert "[4,0,5]".equals(JSONUtil.toJsonStr(res));
    }

}
