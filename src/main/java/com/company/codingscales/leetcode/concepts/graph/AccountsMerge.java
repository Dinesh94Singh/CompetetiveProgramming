package com.company.codingscales.leetcode.concepts.graph;

import com.company.codingscales.standardAlgorithms.UnionFind;

import java.util.*;

public class AccountsMerge {
    private static void recHelper(final String key, final List<String> al, final Set<String> visited, final Map<String, List<String>> graph) {
        visited.add(key);
        al.add(key);

        for(final String neiEmail : graph.get(key)) {
            if (!visited.contains(neiEmail)) {
                recHelper(neiEmail, al, visited, graph);
            }
        }
    }

    public static List<List<String>> accountsMerge(final List<List<String>> accounts) {
        final Map<String, List<String>> graph = new HashMap<>();
        final Map<String, String> emailToName = new HashMap<>();

        for(final List<String> account : accounts) {
            final String name = account.remove(0);
            for(final String email : account) {
                graph.computeIfAbsent(email, s -> new ArrayList<String>()).add(account.get(0));
                graph.computeIfAbsent(account.get(0), s -> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        final Set<String> visited = new HashSet<>();
        final List<List<String>> res = new ArrayList<>();
        for(final String key : graph.keySet()) {
            if (!visited.contains(key)) {
                final List<String> al = new ArrayList<>();
                recHelper(key, al, visited, graph);
                Collections.sort(al);
                al.add(0, emailToName.get(al.get(0)));
                res.add(al);
            }
        }
        return res;
    }

    public static List<List<String>> accountsMergeDSU(final List<List<String>> accounts) {
        final UnionFind uf = new UnionFind(10000);
        final Map<String, Integer> emailToId = new HashMap<>();
        final Map<String, String> emailToName = new HashMap<>();

        int id = 0;
        for(final List<String> account : accounts) {
            final String name = account.remove(0);
            for(final String email : account) {
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }

                uf.union(emailToId.get(email), emailToId.get(account.get(0)));
                emailToName.put(email, name);
            }
        }

        final List<List<String>> res = new ArrayList<>();
        final Map<Integer, List<String>> resMap = new HashMap<>();
        for(final String email : emailToId.keySet()) {
            final int parentIndex = uf.find(emailToId.get(email));
            resMap.computeIfAbsent(parentIndex, s -> new ArrayList<>()).add(email);
        }

        for(final List<String> values : resMap.values()) {
            Collections.sort(values);
            values.add(0, emailToName.get(values.get(0)));
            res.add(values);
        }

        return res;
    }
}
