package com.company.codingscales.interviews.amazon;

import java.util.List;

public class DistanceBetweenNodesInBST {
    // CREATE BST FROM LIST OF NUMS
    static class Node {
        public Node left;
        public Node right;
        int val;

        public Node(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }

    }

    public int constructBSTAndDistanceBetweenNode(List<Integer> nums, int node1, int node2) {
        Node root = null;
        for (int i = 0; i < nums.size(); i++) {
            root = buildBst(root, nums.get(i));
        }

        Node LCA = findLCA(root, node1, node2);
        return distanceBetween(LCA, node1) + distanceBetween(LCA, node2);

    }

    public Node findLCA(Node root, int node1, int node2) {
        if (node1 > root.val && node2 > root.val)
            return findLCA(root.right, node1, node2);
        else if (node1 < root.val && node2 < root.val)
            return findLCA(root.left, node1, node2);
        else
            return root;
    }

    public int distanceBetween(Node LCA, int val) {
        if (LCA.val == val)
            return 0;
        if (val > LCA.val) {
            return distanceBetween(LCA.right, val) + 1;
        } else {
            return distanceBetween(LCA.left, val) + 1;
        }

    }

    public Node buildBst(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val)
            root.left = buildBst(root.left, val);
        else
            root.right = buildBst(root.right, val);
        return root;
    }
}
