package com.company.codingscales.leetcode.concepts.trees;

public class PathSum {
    private boolean dfs(final TreeNode node, final int total, final int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && total + node.val == sum)
            return true;

        return dfs(node.left, total + node.val, sum) || dfs(node.right, total + node.val, sum);
    }

    public boolean hasPathSum(final TreeNode root, final int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, sum);
    }
}
