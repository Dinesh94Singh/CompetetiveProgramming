package com.company.codingscales.leetcode.concepts.slidingWindow;

import java.util.HashMap;

public class MinimumWindowSubString {
    public static String minWindow(final String s, final String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int required = tMap.size();
        int formed = 0;
        int N = s.length();
        int start = 0, end = 0;

        int minlen = Integer.MAX_VALUE;
        int subStart = 0, subEnd = 0;

        while (end < N) {
            char ch = s.charAt(end);

            if (tMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

                if (sMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                    formed++;
                }

                System.out.println("Formed : " + formed + " Required : " + required + " at start Idx " + start + " at end idx " + end);

                while (formed == required && start <= end) {
                    if (minlen > end - start + 1) {
                        minlen = end - start + 1;
                        subStart = start;
                        subEnd = end;
                    }

                    ch = s.charAt(start);
                    if (tMap.containsKey(ch)) {
                        sMap.put(ch, sMap.get(ch) - 1);
                        if (sMap.get(ch).intValue() < tMap.get(ch).intValue()) {
                            formed--;
                        }
                    }

                    start++;
                }
            }

            end++;
        }

        return minlen != Integer.MAX_VALUE ? s.substring(subStart, subEnd + 1) : "";
    }

    public static void main(final String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
