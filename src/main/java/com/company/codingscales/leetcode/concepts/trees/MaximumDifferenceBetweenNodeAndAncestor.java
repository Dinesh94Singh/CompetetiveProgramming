package com.company.codingscales.leetcode.concepts.trees;

public class MaximumDifferenceBetweenNodeAndAncestor {
    int res = Integer.MIN_VALUE;
    void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            res = Math.max(res, max - min);
            return;
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, root.val, root.val);
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
