package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        final ArrayDeque<TreeNode> dq = new ArrayDeque<>();

        dq.offerLast(root);
        int level = 0;
        while (!dq.isEmpty()) {
            final int size = dq.size();
            final LinkedList<Integer> ll = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode node = dq.pollFirst();

                if (level % 2 == 0) {
                    ll.add(node.val);
                } else {
                    ll.addFirst(node.val);
                }

                if (node.left != null) {
                    dq.offerLast(node.left);
                }

                if (node.right != null) {
                    dq.offerLast(node.right);
                }
            }
            res.add(ll);
            level++;
        }

        return res;
    }
}
