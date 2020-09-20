package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class WidthOfBinaryTree {
    static class Pair<U, V> {
        U node;
        V i;
        Pair(final U u, final V v) {
            node = u;
            i = v;
        }

        U getKey() {
            return node;
        }

        V getValue() {
            return i;
        }
    }

    public int widthOfBinaryTree(final TreeNode root) {
        if (root == null)
            return 0;

        final ArrayDeque<Pair<TreeNode, Integer>> dq = new ArrayDeque<>();
        dq.offerLast(new Pair<>(root, 0));
        int ans = Integer.MIN_VALUE;
        while(!dq.isEmpty()) {
            final int size = dq.size();
            final Pair<TreeNode, Integer> head = dq.peekFirst();
            Pair<TreeNode, Integer> t = head;
            for(int i = 0; i < size; i++) {
                t = dq.pollFirst();
                final TreeNode node = t.getKey();
                if (node.left != null) {
                    dq.offerLast(new Pair<>(node.left, t.getValue() * 2));
                }
                if (node.right != null) {
                    dq.offerLast(new Pair<>(node.right, (t.getValue() * 2) + 1));
                }
            }
            ans = Math.max(ans, t.getValue() - head.getValue() + 1);
        }

        return ans;
    }
}
