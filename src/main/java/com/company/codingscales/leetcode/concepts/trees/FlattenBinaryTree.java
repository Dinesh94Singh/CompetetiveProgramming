package com.company.codingscales.leetcode.concepts.trees;

public class FlattenBinaryTree {
    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    static TreeNode prev;
    private static void dfs(final TreeNode root) {
        if (root == null)
            return;

        if (prev != null)
            prev.right = root;

        prev = root;

        final TreeNode left = root.left;
        final TreeNode right = root.right;

        root.left = null;
        root.right = null;

        dfs(left);
        dfs(right);
    }

    // Inorder Morris Traversal'
    public static TreeNode flattenUsingMorrisTraversal(TreeNode root) {
        TreeNode head = new TreeNode();
        TreeNode tail = head;

        TreeNode curr = root;
        TreeNode pred;

        while (curr != null) {

            if (curr.left != null) {
                pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.right;
                } else { // Ideally in morris traversal we would say print(curr.val); pred.right = null; curr = curr.right;
                    tail.right = curr;
                    curr.left = tail; // remove this for balance a binary search tree ?
                    tail = tail.right;
                    curr = curr.right;
                }
            } else { // ideally in morris traversal we would say print(curr.val); curr = curr.right;
                tail.right = curr;
                curr.left = tail; // remove this for balance a binary search tree?
                tail = tail.right;
                curr = curr.right;
            }

        }

        head.right.left = tail;
        tail.left = head.right;

        return head.right;
    }
    public static TreeNode flattenBinaryTree(final TreeNode root) {
        prev = null;
        dfs(root);
        return root;
    }
}
