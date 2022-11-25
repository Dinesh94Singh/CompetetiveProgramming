package com.company.codingscales.leetcode.concepts.trees;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int l = dfs(root.left);
            int r = dfs(root.right);

            if (l == Integer.MAX_VALUE)
                return r + 1;
            else if (r == Integer.MAX_VALUE)
                return l + 1;
            else
                return Math.min(l, r) + 1;
        }
    }
}
