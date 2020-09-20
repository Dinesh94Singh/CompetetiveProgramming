package com.company.codingscales.leetcode.concepts.strings;

import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceInString {
    static class Pair {
        String source;
        String target;

        Pair(String s, String d) {
            source = s;
            target = d;
        }
    }

    /**
     * Often times you encounter, sorting an object based on another object. We have seen this in priorityQueues.
     * Another possibility is to make use of HashMap + Comparator (or) Java's TreeMap if we can use the inbuilt TreeMap
     * This solution makes use of TreeMap. {@link com.company.codingscales.templates.SortingBasedOnOtherArray} for HashMap + Comparator
     */
    public static String findReplaceString(final String s, final int[] indexes, final String[] sources, final String[] targets) {
        // indexes might not be sorted, if we sort, we need to sort the sources and target
        // Sorting based on another array can be done using TreeMap (or) Write a Custom Comparator
        final TreeMap<Integer, Pair> map = new TreeMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new Pair(sources[i], targets[i]));
        }

        int start = 0;
        final StringBuilder res = new StringBuilder();
        for (final Map.Entry<Integer, Pair> entry : map.entrySet()) {
            int end = entry.getKey();
            res.append(s.substring(start, end));
            start = end;
            final String source = entry.getValue().source;
            final String target = entry.getValue().target;
            if (end + source.length() <= s.length()) {
                if (s.substring(end, end + source.length()).equals(source)) {
                    res.append(target);
                    start = end + source.length();
                }
            }
        }
        res.append(s.substring(start));

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(findReplaceString("jjievdtjfb", new int[]{4, 6, 1}, new String[]{"md", "tjqb", "jf"}, new String[]{"foe", "oov", "e"}));
        System.out.println("Expected -> jjievdtjfb");
    }
}
