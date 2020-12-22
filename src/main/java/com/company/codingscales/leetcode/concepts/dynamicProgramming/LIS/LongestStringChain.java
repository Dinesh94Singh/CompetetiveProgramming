package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {
    public static int longestStrChain(final String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        final HashMap<String, Integer> dp = new HashMap<>();
        int res = 0;

        for (final String each : words) {
            int best = 0;
            for(int i = 0; i < each.length(); i++) {
                final String temp = each.substring(0, i) + each.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(temp, 0) + 1);
            }
            dp.put(each, best);
            res = Math.max(res, best);
        }
        return res;
    }
}

