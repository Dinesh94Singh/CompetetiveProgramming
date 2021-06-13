package com.company.codingscales.leetcode.concepts.bfs;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String wrd : wordList) {
            for(int i = 0; i < wrd.length(); i++) {
                String iw = wrd.substring(0, i) + '#' + wrd.substring(i + 1);
                map.putIfAbsent(iw, new ArrayList<>());
                map.get(iw).add(wrd);
            }
        }
        System.out.println(map);

        Deque<String> q = new ArrayDeque<>();
        Set<String> hs = new HashSet<>();

        q.offerLast(beginWord);
        hs.add(beginWord);

        int length = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                String each = q.pollFirst();
                if (each.equals(endWord)) {
                    return length + 1;
                }

                System.out.println(each);
                for(int j = 0; j < each.length(); j++) {
                    String iw = each.substring(0, j) + '#' + each.substring(j + 1);
                    System.out.println("Intermediate word : " + iw);
                    for(String e : map.getOrDefault(iw, new ArrayList<>())) {
                        if (!hs.contains(e)) {
                            q.offerLast(e);
                            hs.add(e);
                        }
                    }
                }
                System.out.println(" ");
            }
            length++;
        }

        return 0;
    }

    // Prefer this solution
    public static class LadderLengthBiDirectionalBFS {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            ArrayDeque<Pair<String, Integer>> dq1 = new ArrayDeque<>();
            ArrayDeque<Pair<String, Integer>> dq2 = new ArrayDeque<>();

            int length = beginWord.length();

            HashMap<String, List<String>> map = new HashMap<>();
            boolean foundEnd = false;
            for(String e : wordList) {

                if (e.equals(endWord))
                    foundEnd = true;

                for(int i = 0; i < length; i++) {
                    String key = e.substring(0, i) + "#" + e.substring(i + 1);

                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(e);
                }
            }

            if (!foundEnd) // if not found, return 0
                return 0;

            dq1.offerLast(new Pair<>(beginWord, 1));
            dq2.offerLast(new Pair<>(endWord, 1));

            HashMap<String, Integer> visited1 = new HashMap<>();
            HashMap<String, Integer> visited2 = new HashMap<>();

            visited1.put(beginWord, 1);
            visited2.put(endWord, 1);

            while (!dq1.isEmpty() && !dq2.isEmpty()) {
                int n = performBFS(length, dq1, visited1, visited2, map);
                if (n > -1)
                    return n;
                n = performBFS(length, dq2, visited2, visited1, map);

                if (n > -1)
                    return n;
            }

            return 0;
        }

        private int performBFS(int l, ArrayDeque<Pair<String, Integer>> dq, Map<String, Integer> visited, Map<String, Integer> otherVisited, Map<String, List<String>> map) {
            Pair<String, Integer> p = dq.pollFirst();
            String key = p.getKey();
            Integer val = p.getValue();

            for(int i = 0; i < l; i++) {
                String t = key.substring(0, i) + "#" + key.substring(i + 1);

                for(String nei : map.getOrDefault(t, new ArrayList<>())) {
                    if (otherVisited.containsKey(nei)) {
                        return val + otherVisited.get(nei);
                    } else if (!visited.containsKey(nei)){
                        visited.put(nei, val + 1);
                        dq.offerLast(new Pair<>(nei, val + 1));
                    }
                }
            }

            return -1;
        }
    }
}
