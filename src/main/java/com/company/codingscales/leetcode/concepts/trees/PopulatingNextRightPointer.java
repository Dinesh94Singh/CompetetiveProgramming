package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class PopulatingNextRightPointer {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        // without using extra space

        if (root == null)
            return null;

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                Node t = q.pollFirst();

                if (t.left != null) {
                    t.left.next = t.right;
                    q.offerLast(t.left);
                }

                if (t.right != null) {
                    t.right.next = t.next != null ? t.next.left : null;
                    q.offerLast(t.right);
                }
            }
        }

        return root;
    }
}
