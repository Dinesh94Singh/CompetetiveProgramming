package com.company.codingscales.leetcode.concepts.trees;

import java.util.Stack;

public class ClosestValueInBinarySearchTree {
    static Integer res;
    static Double closest;

    private void dfs(final TreeNode root, final double target) {
        if (root == null)
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

    public int closestValueEarlyPruning(TreeNode root, double target) {
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        long prev = Integer.MIN_VALUE;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            if (st.isEmpty())
                break;

            TreeNode node = st.pop();

            if (prev <= target && target < node.val) { // early pruning
                return Math.abs(prev - target) < Math.abs(node.val - target) ? (int) prev : node.val;
            }

            prev = node.val;
            curr = node.right;
        }

        return (int) prev;
    }

    /**
     * Similar to {@link RangeSumBST}
     */
    public int closestValueUsingBinarySearch(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
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
