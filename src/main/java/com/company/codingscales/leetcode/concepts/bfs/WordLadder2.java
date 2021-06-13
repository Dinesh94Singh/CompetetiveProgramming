package com.company.codingscales.leetcode.concepts.bfs;

import javafx.util.Pair;

import java.util.*;

public class WordLadder2 {

    static class PureBackTracking {
        List<List<String>> res;
        Integer minDist = Integer.MAX_VALUE;

        // TLE's
        private void dfs(final String word, final String endWord, final int distance, final HashMap<String, List<String>> dict, final List<String> wordList) {
            if (distance > minDist)
                return;
            if (endWord.equals(word)) {
                if (distance > minDist)
                    return;
                if (distance < minDist) {
                    minDist = distance;
                    res.clear();
                }
                res.add(new ArrayList<>(wordList));
                return;
            }

            for (int i = 0; i < word.length(); i++) {
                final String iw = word.substring(0, i) + "#" + word.substring(i + 1);
                for (final String each : dict.getOrDefault(iw, new ArrayList<>())) {
                    if (!wordList.contains(each)) { // prevents cycle
                        wordList.add(each);
                        dfs(each, endWord, distance + 1, dict, wordList);
                        wordList.remove(wordList.size() - 1);
                    }
                }
            }
        }

        public List<List<String>> findLadders(final String beginWord, final String endWord, final List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty())
                return new ArrayList<>();
            if (beginWord.equals(endWord))
                return new ArrayList<>();

            final HashMap<String, List<String>> dict = new HashMap<>();
            res = new ArrayList<>();
            for (final String each : wordList) {
                for (int i = 0; i < each.length(); i++) {
                    final String iw = each.substring(0, i) + "#" + each.substring(i + 1);
                    dict.putIfAbsent(iw, new ArrayList<>());
                    dict.get(iw).add(each);
                }
            }

            final List<String> wl = new ArrayList<>();
            wl.add(beginWord);

            dfs(beginWord, endWord, 0, dict, wl);
            return res;
        }

        public static void main(String[] args) {
        }
    }

    // still TLE's
    static class BFSWithBackTracking {
        public static class LadderLengthBiDirectionalBFS {
            HashMap<String, List<String>> map;
            public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                ArrayDeque<Pair<String, Integer>> dq1 = new ArrayDeque<>();
                ArrayDeque<Pair<String, Integer>> dq2 = new ArrayDeque<>();

                int length = beginWord.length();

                map = new HashMap<>();
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

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // find the shortest path between the beginWord and endWord
            // perform dfs early pruning + backtracking to get the answer instead of doing backtracking all the time
            var t = new LadderLengthBiDirectionalBFS();
            int n = t.ladderLength(beginWord, endWord, wordList);

            if (n == 0)
                return new ArrayList<>(); // no path
            List<String> al = new ArrayList<>();
            al.add(beginWord);

            dfs(n, 1, beginWord, endWord, t.map, al);
            return res;
        }

        HashSet<String> visited = new HashSet<>();

        private void dfs(int n, int curr, String currWord, String endWord, Map<String, List<String>> map, List<String> t) {
            if (n == curr) {
                if (currWord.equals(endWord)) {
                    res.add(new ArrayList<>(t));
                }

                return;
            }

            visited.add(currWord);

            for(int i = 0; i < currWord.length(); i++) {
                String key = currWord.substring(0, i) + "#" + currWord.substring(i + 1);

                for(String nei : map.getOrDefault(key, new ArrayList<>())) {
                    if (visited.contains(nei))
                        continue;

                    t.add(nei);
                    dfs(n, curr + 1, nei, endWord, map, t);
                    t.remove(t.size() - 1);
                }
            }

            visited.remove(currWord);
        }
    }

    // Working Solution
    static class StoreDistanceFromSource {
        public static class LadderLengthBFS {
            HashMap<String, List<String>> map;
            HashMap<String, Integer> distance;

            public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                map = new HashMap<>();
                distance = new HashMap<>();

                for(String wrd : wordList) {
                    for(int i = 0; i < wrd.length(); i++) {
                        String iw = wrd.substring(0, i) + '#' + wrd.substring(i + 1);
                        map.putIfAbsent(iw, new ArrayList<>());
                        map.get(iw).add(wrd);
                    }
                }


                Deque<String> q = new ArrayDeque<>();
                Set<String> hs = new HashSet<>();

                q.offerLast(beginWord);
                hs.add(beginWord);

                distance.put(beginWord, 0);

                int length = 1;
                boolean foundEnd = false;
                while (!q.isEmpty()) {
                    int n = q.size();
                    for(int i = 0; i < n; i++) {
                        String each = q.pollFirst();
                        if (each.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            for(int j = 0; j < each.length(); j++) {
                                String iw = each.substring(0, j) + '#' + each.substring(j + 1);

                                for(String e : map.getOrDefault(iw, new ArrayList<>())) {
                                    if (!hs.contains(e)) {
                                        distance.put(e, length);
                                        q.offerLast(e);
                                        hs.add(e);
                                    }
                                }
                            }
                        }
                    }

                    if (foundEnd)
                        break;
                    length++;
                }


                if (!foundEnd)
                    return 0;
                return length;
            }
        }

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // find the shortest path between the beginWord and endWord
            // perform dfs early pruning + backtracking to get the answer instead of doing backtracking all the time

            var t = new LadderLengthBFS();
            int n = t.ladderLength(beginWord, endWord, wordList);

            // System.out.println(t.distance);

            if (n == 0)
                return new ArrayList<>(); // no path
            List<String> al = new ArrayList<>();
            al.add(beginWord);

            dfs(n, 1, beginWord, endWord, t.map, al, t.distance);
            return res;
        }

        HashSet<String> visited = new HashSet<>();

        private void dfs(int n, int curr, String currWord, String endWord, Map<String, List<String>> map, List<String> t, Map<String, Integer> distance) {
            if (n <= curr) {
                if (currWord.equals(endWord)) {
                    res.add(new ArrayList<>(t));
                }

                return;
            }

            visited.add(currWord);

            for(int i = 0; i < currWord.length(); i++) {
                String key = currWord.substring(0, i) + "#" + currWord.substring(i + 1);

                for(String nei : map.getOrDefault(key, new ArrayList<>())) {

                    // System.out.println(currWord + " - " + nei + " => " + distance);
                    if (visited.contains(nei))
                        continue;
                    if (distance.containsKey(nei) && distance.get(nei) != distance.getOrDefault(currWord, -99) + 1)
                        continue;

                    t.add(nei);
                    dfs(n, curr + 1, nei, endWord, map, t, distance);
                    t.remove(t.size() - 1);
                }
            }

            visited.remove(currWord);
        }
    }
}
