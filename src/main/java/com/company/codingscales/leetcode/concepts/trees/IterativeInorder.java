package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class IterativeInorder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        final ArrayDeque<TreeNode> st = new ArrayDeque<>();
        final List<Integer> res = new ArrayList<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.offerLast(root);
                root = root.left;
            }

            if (st.isEmpty()) {
                break;
            }
            final TreeNode curr = st.pollLast();
            res.add(curr.val);
            root = curr.right;
        }

        return res;
    }
}
