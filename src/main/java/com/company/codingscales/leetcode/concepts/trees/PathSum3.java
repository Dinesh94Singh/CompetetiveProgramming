package com.company.codingscales.leetcode.concepts.trees;

public class PathSum3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int count = 0;

    void recHelper(TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.val == sum)
            count++;
        recHelper(root.left, sum - root.val);
        recHelper(root.right, sum - root.val);
    }

    void helper(TreeNode root, int sum) {
        if (root == null)
            return;

        recHelper(root, sum);
        helper(root.left, sum); // start the node at left
        helper(root.right, sum); // start the node at right
    }

    public int pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return count;
    }
}
