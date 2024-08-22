package org.example.tree.split;

import org.example.base.TreeNode;
import org.example.util.TreeUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * 以前序+后序构建二叉树
 */
public class BuildTree3Test {

    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 以前序的preStart+1下标的元素为左子树的根节点
        Integer index = valToIndex.get(preorder[preStart + 1]);
        int leftSize = index - postStart + 1;

        // 分别构建左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }


    @Test
    public void case1() {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode res = constructFromPrePost(preorder, postorder);
        TreeUtil.print(res);
    }

    @Test
    public void case2() {
        int[] preorder = new int[]{-1};
        int[] postorder = new int[]{-1};
        TreeNode res = constructFromPrePost(preorder, postorder);
        TreeUtil.print(res);
    }
}
