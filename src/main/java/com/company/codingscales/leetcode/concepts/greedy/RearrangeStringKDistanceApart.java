package com.company.codingscales.leetcode.concepts.greedy;

import javafx.util.Pair;

import java.util.*;

public class RearrangeStringKDistanceApart {

    // TODO: Doesn't pass the last test case. Need to debug and fix it. Temp
    public String rearrangeString(String s, int k) {
        if (k == 0)
            return s;

        final PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((curr, other) -> {
            if (other.getValue() != curr.getValue())
                return other.getValue() - curr.getValue();
            return curr.getKey() - other.getKey();
        });
        final HashMap<Character, Integer> hm = new HashMap<>();
        for (final char c : s.toCharArray()) {
            hm.putIfAbsent(c, 0);
            hm.put(c, hm.get(c) + 1);
        }

        for (final Map.Entry<Character, Integer> entry : hm.entrySet()) {
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        final StringBuilder sb = new StringBuilder();

        while (pq.size() >= k) {

            int t = k;
            List<Pair<Character, Integer>> buf = new ArrayList<>();
            while(t-- > 0) {
                if (pq.isEmpty())
                    return "";
                final Pair<Character, Integer> p1 = pq.poll();
                sb.append(p1.getKey());

                if (p1.getValue() > 1) {
                    buf.add(new Pair<>(p1.getKey(), p1.getValue() - 1));
                }
            }

            pq.addAll(buf);
        }

        while (!pq.isEmpty())
            sb.append(pq.poll().getKey()); // only add 1 char.

        if (sb.length() != s.length())
            return "";

        return sb.toString();
    }
}
