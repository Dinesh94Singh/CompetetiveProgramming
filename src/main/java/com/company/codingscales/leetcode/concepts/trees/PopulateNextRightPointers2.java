package com.company.codingscales.leetcode.concepts.trees;

public class PopulateNextRightPointers2 {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    Node prev, leftmost;

    public void processChild(Node childNode) {
        if (childNode != null) {
            if (this.prev != null) {
                this.prev.next = childNode;
            } else {
                this.leftmost = childNode;
            }

            this.prev = childNode;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        this.leftmost = root;

        Node curr;

        while (this.leftmost != null) {
            this.prev = null;
            curr = this.leftmost;

            this.leftmost = null;

            while (curr != null) {
                this.processChild(curr.left);
                this.processChild(curr.right);

                curr = curr.next;
            }
        }

        return root ;
    }
}
