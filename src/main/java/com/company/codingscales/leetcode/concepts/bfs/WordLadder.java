package com.company.codingscales.leetcode.concepts.bfs;

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
}
