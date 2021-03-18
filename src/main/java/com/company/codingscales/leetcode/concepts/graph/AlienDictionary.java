package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        int N = words.length;
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for(String e : words) {
            for(char ch : e.toCharArray()) {
                graph.put(ch, new ArrayList<>());
                indegree.put(ch, 0);
            }
        }

        for(int i = 0; i < N - 1; i++) {
            String t1 = words[i];
            String t2 = words[i + 1];

            if (t1.length() > t2.length() && t1.startsWith(t2))
                return "";

            int j;
            int minimumLen = Math.min(t1.length(), t2.length());
            for(j = 0; j < minimumLen; j++) {
                if (t1.charAt(j) != t2.charAt(j))
                    break;
            }

            if (minimumLen == j)
                continue;

            graph.putIfAbsent(t1.charAt(j), new ArrayList<>());
            graph.get(t1.charAt(j)).add(t2.charAt(j)); // t1 should come before t2;
            indegree.put(t2.charAt(j), indegree.getOrDefault(t2.charAt(j), 0) + 1);
        }

        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(Character key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                dq.offer(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (dq.isEmpty())
            return "";
        while (!dq.isEmpty()) {
            char t = dq.pollFirst();
            sb.append(t);
            for (Character children : graph.getOrDefault(t, new ArrayList<>())) {
                indegree.put(children, indegree.get(children) - 1);

                if (indegree.get(children) == 0)
                    dq.offerLast(children);
            }
        }

        return sb.length() != indegree.size() ? "" : sb.toString();
    }
}
