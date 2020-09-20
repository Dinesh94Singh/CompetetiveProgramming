package com.company.codingscales.leetcode.concepts.trees;

public class GreaterSumTree {
    int total = 0;
    private void dfs(final TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);

        root.val = root.val + total;
        total = root.val;

        dfs(root.left);
    }

    public TreeNode bstToGst(final TreeNode root) {
        dfs(root);
        return root;
    }
}
