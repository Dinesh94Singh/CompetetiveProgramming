package com.company.codingscales.leetcode.concepts.trees;

public class LowestCommonAncestorOfBinaryTree {
    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    TreeNode ans = null;
    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean isLeft = dfs(root.left, p, q);
        boolean isRight = dfs(root.right, p, q);
        boolean curr = root.val == p.val || root.val == q.val;

        int x = isLeft ? 1 : 0;
        int y = isRight ? 1 : 0;
        int z = curr ? 1 : 0;

        if (x + y + z >= 2) {
            ans = root;
        }

        return isLeft || isRight || curr;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
