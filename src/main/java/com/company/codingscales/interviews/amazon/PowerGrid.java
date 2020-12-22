package com.company.codingscales.interviews.amazon;

import javafx.util.Pair;

import java.util.*;

// MinimumSpanningTree of graph
public class PowerGrid {
    // LC Problems - Min cost to repair and min cost to connect all
    // Cheapest flights within K stops
    // Find Critical and psuedo critical edges in minimum spanning tree.

    static class Node {
        Character src;
        Character dest;
        int cost;

        Node(char s, char d, int cost) {
            src = s;
            dest = d;
            this.cost = cost;
        }
    }

    int solve(int N, List<Node> edges) {
        HashMap<Character, List<Pair<Integer, Character>>> graph = new HashMap<>();
        for(Node edge : edges) {
            Character s = edge.src;
            Character d = edge.dest;
            int cost = edge.cost;

            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(new Pair<>(cost, d));
        }

        Character start = edges.get(0).src;

        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((a, b) -> {
            return a.getKey() - b.getKey();
        });

        int cost = 0;

        pq.addAll(graph.get(start));
        HashSet<Character> visited = new HashSet<>();
        visited.add(start);
        while (!pq.isEmpty()) {
            Pair<Integer, Character> node = pq.poll();
            Character dst = node.getValue();
            if (visited.contains(dst)) {
                continue;
            }

            cost += node.getKey();

            pq.addAll(graph.getOrDefault(node.getValue(), new ArrayList<>()));
        }

        if (visited.size() != edges.size())
            return -1;

        return cost;
    }
}
