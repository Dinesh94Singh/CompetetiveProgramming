package com.company.codingscales.leetcode.concepts.graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        ArrayDeque<Node> dq = new ArrayDeque<>();

        dq.offerLast(node);

        map.put(node, new Node(node.val));

        HashSet<Node> visited = new HashSet<>();
        while (!dq.isEmpty()) {
            Node n = dq.pollFirst();

            if (visited.contains(n))
                continue;

            visited.add(n);
            Node clone = map.get(n);
            for(Node nei : n.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val)); // clone the node;
                }

                clone.neighbors.add(map.get(nei));
                dq.offerLast(nei);
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors.add(one);
        four.neighbors.add(three);

        cloneGraph(one);
    }
}
