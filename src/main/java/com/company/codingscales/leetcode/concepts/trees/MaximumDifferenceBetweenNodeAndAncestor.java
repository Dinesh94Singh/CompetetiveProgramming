package com.company.codingscales.leetcode.concepts.trees;

public class MaximumDifferenceBetweenNodeAndAncestor {
    int res = 0;
    private void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        res = Math.max(res, Math.abs(min - root.val));
        res = Math.max(res, Math.abs(max - root.val));


        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }
}
