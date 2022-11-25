package com.company.codingscales.leetcode.concepts.trees;

public class IsBalancedTree {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode r) {
        if (r == null)
            return 0;

        if (!ans)
            return 0;

        int l = dfs(r.left);
        int ri = dfs(r.right);

        if (Math.abs(ri - l) > 1) {
            ans = false;
            return 0;
        }

        return Math.max(l, ri) + 1;
    }
}
