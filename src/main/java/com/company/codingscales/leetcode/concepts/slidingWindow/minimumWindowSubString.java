package com.company.codingscales.leetcode.concepts.slidingWindow;

import java.util.HashMap;

public class minimumWindowSubString {
    public static String minWindow(final String s, final String t) {
        final HashMap<Character, Integer> tCounter = new HashMap<>();
        final HashMap<Character, Integer> windowCounter = new HashMap<>();
        final int tLength = t.length();
        final int sLength = s.length();

        for(final char c: t.toCharArray()) {
            tCounter.putIfAbsent(c, 0);
            tCounter.put(c, tCounter.get(c) + 1);
        }


        final int remaining = tCounter.size();
        int formed = 0;
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int subStringStart = 0;
        int subStringEnd = 0;

        char ch;

        while(end < sLength) {
            ch = s.charAt(end);

            if (tCounter.containsKey(ch)) {
                windowCounter.putIfAbsent(ch, 0);
                windowCounter.put(ch, windowCounter.get(ch) + 1);

                if (windowCounter.get(ch) == tCounter.get(ch)) {
                    formed++;
                }
            }

            while (start < end && formed == remaining) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    subStringStart = start;
                    subStringEnd = end;
                }
                if (tCounter.containsKey(s.charAt(start))) {
                    windowCounter.put(s.charAt(start), windowCounter.get(s.charAt(start)) - 1);
                    if (windowCounter.get(s.charAt(start)) < tCounter.get(s.charAt(start)))
                        formed--;
                }

                start += 1;

            }

            end += 1;
        }

        return minLength == Integer.MAX_VALUE ? "": s.substring(subStringStart, subStringEnd + 1);
    }

    public static void main(final String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
