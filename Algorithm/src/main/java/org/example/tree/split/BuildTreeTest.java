package org.example.tree.split;

import org.example.base.TreeNode;
import org.example.util.TreeUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class BuildTreeTest {

    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记录中序的节点值与下标的映射关系
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                      int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return  null;

        // 构造根节点
        int rootVal = preorder[preStart];

        // 左子树节点数量
        Integer index = valToIndex.get(rootVal);
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        // 分别构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }

    @Test
    public void case1() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode res = buildTree(preorder, inorder);
        TreeUtil.print(res);
    }

    @Test
    public void case2() {
        int[] preorder = new int[]{-1};
        int[] inorder = new int[]{-1};
        TreeNode res = buildTree(preorder, inorder);
        TreeUtil.print(res);
    }
}
