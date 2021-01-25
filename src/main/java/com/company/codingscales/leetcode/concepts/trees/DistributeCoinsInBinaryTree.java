package com.company.codingscales.leetcode.concepts.trees;

public class DistributeCoinsInBinaryTree {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
