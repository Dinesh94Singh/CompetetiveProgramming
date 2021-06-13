package com.company.codingscales.leetcode.concepts.trees;

public class LowestCommonAncestorOfBinaryTree3 {
    static class Node {
        int val;
        Node parent;
        Node left;
        Node right;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        // similar to Intersection of Linked List
        Node p1 = p;
        Node p2 = q;

        while (p1 != p2) {
            p1 = (p1 == null) ? q : p1.parent;
            p2 = (p2 == null) ? p : p2.parent;
        }

        return p1;
    }

}
