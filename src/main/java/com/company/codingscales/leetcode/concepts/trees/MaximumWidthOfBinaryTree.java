package com.company.codingscales.leetcode.concepts.trees;

import javafx.util.Pair;

import java.util.ArrayDeque;

public class MaximumWidthOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int widthOfBinaryTree(final TreeNode root) {
        final ArrayDeque<Pair<TreeNode, Integer>> dq = new ArrayDeque<>();
        dq.offerLast(new Pair<>(root, 0));
        int ans = Integer.MIN_VALUE;

        while (!dq.isEmpty()) {
            int size = dq.size();

            final Pair<TreeNode, Integer> first = dq.peekFirst();
            Pair<TreeNode, Integer> last = dq.peekFirst();

            for(int i = 0; i < size; i++) {
                last = dq.pollFirst();
                final TreeNode node = last.getKey();
                if (node.left != null)
                    dq.offerLast(new Pair<>(node.left, 2 * last.getValue()));

                if (node.right != null)
                    dq.offerLast(new Pair<>(node.right, 2 * last.getValue() + 1));
            }
            ans = Math.max(ans, first.getValue() - last.getValue());
        }

        return ans;
    }
}
