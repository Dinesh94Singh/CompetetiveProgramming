package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }

        if (word1.equals(word2) && map.get(word1).size() > 1) {
            List<Integer> t = map.get(word1);
            int minDist = Integer.MAX_VALUE;

            int i = 0;
            while (i < t.size() - 1) {
                minDist = Math.min(minDist, t.get(i + 1) - t.get(i));
                i++;
            }

            return minDist == Integer.MAX_VALUE ? -1 : minDist;
        }


        List<Integer> t1 = map.getOrDefault(word1, new ArrayList<>());
        List<Integer> t2 = map.getOrDefault(word2, new ArrayList<>());

        int l1 = 0, l2 = 0;

        int minDist = Integer.MAX_VALUE;

        while (l1 < t1.size() && l2 < t2.size()) {

            minDist = Math.min(minDist, Math.abs(t2.get(l2) - t1.get(l1)));

            if (t1.get(l1) < t2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }

        if (minDist == Integer.MAX_VALUE)
            return -1;

        return minDist;
    }
}
