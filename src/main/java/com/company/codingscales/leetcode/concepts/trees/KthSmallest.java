package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        final ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.addLast(root);
                root = root.left;
            }
            // root is the
            if (stack.isEmpty()) return -1; // cant find
            final TreeNode top = stack.removeLast();
            if (k == 1) return top.val;
            k -= 1;
            root = top.right;
        }
        return -1;
    }
}
