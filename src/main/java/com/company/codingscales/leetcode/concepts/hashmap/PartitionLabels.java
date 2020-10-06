package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels(final String S) {
        final HashMap<Character, Integer> occr = new HashMap<>();

        for(int i = 0; i < S.length(); i++) {
            final char ch = S.charAt(i);
            occr.put(ch, i);
        }

        int maxPos = Integer.MIN_VALUE;
        int prevPos = -1;
        final List<Integer> res = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            final char ch = S.charAt(i);
            maxPos = Math.max(maxPos, occr.get(ch));

            if (i == maxPos) {
                res.add(i - prevPos);
                prevPos = i;
            }
        }

        return res;
    }
}
