package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.*;

public class ConcatenatedWords {
    static HashMap<String, Boolean> cache;

    private static boolean dfs(final String each, final HashSet<String> words) {
        if (cache.containsKey(each))
            return cache.get(each);
        for(int i = 1; i < each.length(); i++) {
            final String prefix = each.substring(0, i);
            final String suffix = each.substring(i);

            if (words.contains(prefix) && words.contains(suffix)) {
                cache.put(each, true);
                return true;
            }

            if (words.contains(prefix) && dfs(suffix, words)) {
                cache.put(each, true);
                return true;
            }
        }

        cache.put(each, false);
        return false;
    }

    public static List<String> findAllConcatenatedWordsInADict(final String[] w) {
        cache = new HashMap<>();
        final HashSet<String> words = new HashSet<>(Arrays.asList(w));
        final List<String> res = new ArrayList<>();
        for (final String each : words) {
            if (each.isEmpty())
                continue;
            if (dfs(each, words)) {
                res.add(each);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final List<String> res = findAllConcatenatedWordsInADict(new String[] {"cat", "cats", "dog", "catsdogcats"});
        for(final String e : res)
            System.out.printf("%s \t", e);
    }
}
