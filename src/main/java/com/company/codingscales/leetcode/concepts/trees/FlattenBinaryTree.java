package com.company.codingscales.leetcode.concepts.trees;

public class FlattenBinaryTree {
    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    static TreeNode prev;
    private static void dfs(final TreeNode root) {
        if (root == null)
            return;

        if (prev != null)
            prev.right = root;

        prev = root;

        final TreeNode left = root.left;
        final TreeNode right = root.right;

        root.left = null;
        root.right = null;

        dfs(left);
        dfs(right);


    }
    public static TreeNode flattenBinaryTree(final TreeNode root) {
        prev = null;
        dfs(root);
        return root;
    }
}
