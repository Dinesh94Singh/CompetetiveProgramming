package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;

public class FindRootOfNaryTree {
    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node findRoot(List<Node> tree) {
        HashSet<Node> seen = new HashSet<>();
        for (Node n : tree) {
            seen.addAll(n.children);
        }

        for (Node n : tree) {
            if (!seen.contains(n))
                return n;
        }

        return null;
    }
}
