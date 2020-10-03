package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SerializeAndDeserializeABinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(final int x) { val = x; }
    }

    private void s_helper(TreeNode root, ArrayList<String> al) {
        if (root == null) {
            al.add("null");
            return;
        }

        al.add(String.valueOf(root.val));
        s_helper(root.left, al);
        s_helper(root.right, al);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> al = new ArrayList<>();
        s_helper(root, al);

        return al.stream().collect(Collectors.joining(","));
    }

    private static int index;

    private TreeNode d_helper(String[] nodes) {
        if (nodes.length == 0 || nodes.length == index)
            return null;

        String val = nodes[index];
        index++;

        if (val.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = d_helper(nodes);
        root.right = d_helper(nodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String nodes[] = data.split(",");
        return d_helper(nodes);
    }
}
