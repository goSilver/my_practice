package org.example.tree.split;

import org.example.base.TreeNode;
import org.example.util.TreeUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2Test {
    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        Integer index = valToIndex.get(rootVal);
        int leftSize = index - inStart;

        root.left = build(postorder, postStart, postStart + leftSize - 1,
                inorder, inStart, index - 1);
        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                inorder, index + 1, inEnd);
        return root;
    }

    @Test
    public void case1() {
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode res = buildTree(inorder, postorder);
        TreeUtil.print(res);
    }

    @Test
    public void case2() {
        int[] postorder = new int[]{-1};
        int[] inorder = new int[]{-1};
        TreeNode res = buildTree(inorder, postorder);
        TreeUtil.print(res);
    }
}
