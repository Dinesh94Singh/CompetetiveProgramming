package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance3 {
    private HashMap<String, List<Integer>> map;

    public WordDistance3(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            map.putIfAbsent(word, new ArrayList<Integer>());
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> al1 = map.getOrDefault(word1, new ArrayList<>());
        List<Integer> al2 = map.getOrDefault(word2, new ArrayList<>());

        int i = 0, j = 0;

        int shortest = Integer.MAX_VALUE;

        while (i < al1.size() && j < al2.size()) {
            if (shortest > Math.abs(al1.get(i) - al2.get(j))) {
                shortest = Math.abs(al1.get(i) - al2.get(j));
            }

            if (al1.get(i) < al2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return shortest;
    }
}
