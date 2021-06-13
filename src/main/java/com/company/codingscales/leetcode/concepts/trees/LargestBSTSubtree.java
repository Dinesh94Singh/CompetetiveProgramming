package com.company.codingscales.leetcode.concepts.trees;

public class LargestBSTSubtree {
    static class Tuple {
        int val;
        int lower;
        int upper;

        Tuple(int a, int b, int c) {
            val = a;
            lower = b;
            upper = c;
        }
    }


    int ans = 0;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Tuple dfs(TreeNode root) {
        if (root == null) {
            return new Tuple(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Tuple left = dfs(root.left);
        Tuple right = dfs(root.right);

        if (left.val == -1 || right.val == -1 || left.upper >= root.val || right.lower <= root.val) {
            return new Tuple(-1, 0, 0);
        }

        int total = 1 + left.val + right.val;
        ans = Math.max(ans, total);

        // return total number of elements, lowest value in left subtree and highest value in right subtree
        return new Tuple(total, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
