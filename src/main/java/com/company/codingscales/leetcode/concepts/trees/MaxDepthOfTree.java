package com.company.codingscales.leetcode.concepts.trees;

public class MaxDepthOfTree {
    private int recHelper(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int left = recHelper(root.left);
        final int right = recHelper(root.right);

        return Math.max(left, right) + 1;
    }

    public int maxDepth(final TreeNode root) {
        return recHelper(root);
    }
}
