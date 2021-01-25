package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeNaryTree {
    static class Node {
        int val;
        List<Node> children;

        Node(int val) { this.val = val; }
        Node(int val, List<Node> children) { this.val = val; this.children = children; }
    }

    List<String> list;
    void serHelper(Node root) {
        if (root == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));
        for(Node each : root.children) {
            serHelper(each);
        }
        list.add("#");
    }

    public String serialize(Node root) {
        if (root == null)
            return null;
        list = new ArrayList<String>();

        serHelper(root);

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null)
            return null;
        ArrayList<String> al = new ArrayList<>(Arrays.asList(data.split(",")));
        Stack<Node> st = new Stack<>();

        for(String val : al.subList(0, al.size() - 1)) {
            if (!val.equals("#")) {
                st.push(new Node(Integer.parseInt(val), new ArrayList<>()));
            } else {
                Node n = st.pop();
                st.peek().children.add(n);
            }
        }

        return st.peek();
    }
}
