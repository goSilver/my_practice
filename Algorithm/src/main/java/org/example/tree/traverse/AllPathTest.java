package org.example.tree.traverse;

import cn.hutool.json.JSONUtil;
import org.example.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class AllPathTest {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPath(TreeNode root) {
        if (root == null) return null;
        List<Integer> cur = new ArrayList<>();
        traverse(root, cur);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> cur) {
        if (root == null) {
            return;
        }
        // path前进
        cur.add(root.val);

        // 叶子节点时记录path
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(cur));
        }

        traverse(root.left, cur);
        traverse(root.right, cur);

        // path后退
        cur.remove(cur.size()-1);
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

         result：[[1,2,3],[1,2,4],[1,5,6,7]]
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right  = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        List<List<Integer>> result = allPath(root);
        System.out.println(JSONUtil.toJsonStr(result));
    }
}
