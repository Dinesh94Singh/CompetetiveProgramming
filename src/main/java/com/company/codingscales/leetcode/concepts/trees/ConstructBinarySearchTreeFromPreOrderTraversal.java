package com.company.codingscales.leetcode.concepts.trees;

import java.util.HashMap;

public class ConstructBinarySearchTreeFromPreOrderTraversal {
    static int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int lo, int hi) {
        if (idx == preorder.length)
            return null;
        if (lo > hi)
            return null;

        int t = preorder[idx];
        idx++;
        int inIdx = map.get(t);
        TreeNode curr = new TreeNode(t);
        curr.left = dfs(preorder, inorder, lo, inIdx - 1);
        curr.right = dfs(preorder, inorder, inIdx + 1, hi);

        return curr;
    }
}
