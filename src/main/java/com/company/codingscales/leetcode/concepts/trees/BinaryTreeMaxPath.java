package com.company.codingscales.leetcode.concepts.trees;

public class BinaryTreeMaxPath {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(final int x) { val = x; }
    }

    int maximum = Integer.MIN_VALUE;

    int dfs(final TreeNode root) {
        if (root == null)
            return 0;

        final int left = Math.max(0, dfs(root.left));
        final int right = Math.max(0, dfs(root.right));

        maximum = Math.max(maximum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(final TreeNode root) {
        dfs(root);
        return maximum;
    }
}
