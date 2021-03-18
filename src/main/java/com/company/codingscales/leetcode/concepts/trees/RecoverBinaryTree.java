package com.company.codingscales.leetcode.concepts.trees;

import java.util.Stack;

public class RecoverBinaryTree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode prev = null;

        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            if (st.isEmpty())
                break;

            root = st.pop();
            if (prev != null && prev.val > root.val) {
                y = root;
                if (x == null)
                    x = prev;
                else
                    break;
            }
            prev = root;
            root = root.right;
        }

        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }
}
