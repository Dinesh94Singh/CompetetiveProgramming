package com.company.codingscales.leetcode.concepts.trees;

import java.util.Stack;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int total = 0;

        while (!st.isEmpty()) {
            root = st.pop();

            if (root != null) {
                if (low <= root.val && root.val <= high) {
                    total += root.val;
                }

                if (low < root.val) {
                    st.push(root.left);
                }

                if (root.val < high) {
                    st.push(root.right);
                }
            }
        }

        return total;
    }
}
