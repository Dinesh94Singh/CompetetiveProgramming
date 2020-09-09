package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class TreeToDoubleLinkedList {
    static class Node {
        int val;
        Node left;
        Node right;
    }

    public static Node treeToDoublyList(Node root) {
        Node head = null;
        Node tail = null;
        final ArrayDeque<Node> st = new ArrayDeque<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.offerLast(root);
                root = root.left;
            }

            if (st.isEmpty()) {
                break;
            }
            final Node curr = st.pollLast();
            if (head == null) {
                head = curr;
            } else {
                tail.right = curr;
                curr.left = tail;
            }
            tail = curr;

            root = curr.right;
        }

        if (head == null) {
            return null;
        }
        tail.right = head;
        head.left = tail;

        return head;
    }
}
