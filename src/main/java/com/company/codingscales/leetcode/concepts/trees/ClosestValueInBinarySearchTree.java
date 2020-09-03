package com.company.codingscales.leetcode.concepts.trees;

public class ClosestValueInBinarySearchTree {
    static Integer res;
    static Double closest;

    private void dfs(final TreeNode root, final double target) {
        if(root == null)
            return;

        final double diff = Math.abs(root.val - target);
        if (diff < closest) {
            closest = diff;
            res = root.val;
        }

        dfs(root.left, target);
        dfs(root.right, target);
    }

    public int closestValue(final TreeNode root, final double target) {
        if (root == null) {
            return 0;
        }

        res = Integer.MAX_VALUE;
        closest = Double.MAX_VALUE;
        dfs(root, target);
        return res;
    }

    public static void main(final String[] args) {
        final ClosestValueInBinarySearchTree closestValueInBinarySearchTree = new ClosestValueInBinarySearchTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(closestValueInBinarySearchTree.closestValue(root, 3.714286));
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(closestValueInBinarySearchTree.closestValue(root, 3.71));
    }
}
