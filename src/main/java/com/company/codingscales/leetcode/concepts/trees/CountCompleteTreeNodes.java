package com.company.codingscales.leetcode.concepts.trees;

public class CountCompleteTreeNodes {
    // o(n) linear solution which iterates through all nodes.
    public static int countNodes(final TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // complete tree given, so, just explore the left most nodes depth
    private static int depth(final TreeNode root) {
        if (root == null)
            return 0;
        return 1 + depth(root.left);
    }

    private static boolean binarySearch(final int index, final int d, TreeNode root) {
        int left = 0, right = (int) (Math.pow(2, d) - 1);
        int mid;

        for(int i = 0; i < d; i++) {
            mid = left + (right - left) / 2;
            if (index <= mid) {
                root = root.left;
                right = index;
            } else {
                root = root.right;
                left = index + 1;
            }
        }

        return root != null;
    }


    public static int countNodesBinarySearch(final TreeNode root) {
        final int d = depth(root);
        int left = 0, right = (int) (Math.pow(2, d) - 1);
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (binarySearch(mid, d, root)) {
                left = mid + 1; // exists
            } else {
                right = mid - 1; // doesn't exists
            }
        }

        return (int) (Math.pow(2, d) - 1) + left;
    }

    public static void main(final String[] args) {
    }
}
