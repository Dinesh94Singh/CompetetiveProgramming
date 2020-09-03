package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    int[] cache;

    private boolean recHelper(final String s, final int index, final Set<String> words) {
        if (index == s.length()) {
            return true;
        }

        if (cache[index] != -1) {
            return cache[index] == 1;
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (words.contains(sb.toString()) && recHelper(s, i + 1, words)) {
                cache[index] = 1;
                return true;
            }
        }

        cache[index] = words.contains(sb.toString()) ? 1 : 0;
        return cache[index] == 1;
    }

    public boolean wordBreak(final String s, final List<String> wordDict) {
        final Set<String> words = new HashSet<String>(wordDict);
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return recHelper(s, 0, words);

    }
}
