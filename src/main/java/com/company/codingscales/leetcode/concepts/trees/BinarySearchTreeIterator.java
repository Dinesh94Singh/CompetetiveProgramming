package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class BinarySearchTreeIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    ArrayDeque<TreeNode> st;
    public BinarySearchTreeIterator(TreeNode root) {
        st = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null) {
            st.offerLast(curr);
            curr = curr.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (!st.isEmpty()) {
            TreeNode curr = st.pollLast();
            int val = curr.val;
            curr = curr.right;

            while (curr != null) {
                st.offerLast(curr);
                curr = curr.left;
            }

            return val;
        }

        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
