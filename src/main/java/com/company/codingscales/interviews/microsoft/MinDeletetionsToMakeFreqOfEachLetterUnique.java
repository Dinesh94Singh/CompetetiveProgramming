package com.company.codingscales.interviews.microsoft;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class MinDeletetionsToMakeFreqOfEachLetterUnique {

    private static int solve(final String s) {
        final Map<Character, Integer> map = new TreeMap<>();
        for(final char c: s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        final HashSet<Integer> hs = new HashSet<>();
        int res = 0;
        for(int count : map.values()) {
            if (!hs.contains(count))
                hs.add(count);
            else {
                while (count > 0 && hs.contains(count)) {
                    res++;
                    count--;
                }
                if (count > 0)
                    hs.add(count);
            }
        }

        return res;
    }

    public static void main(final String[] args) {
        System.out.println(solve("eeeeffff"));
        System.out.println(solve("aabbffddeaee"));
    }
}
