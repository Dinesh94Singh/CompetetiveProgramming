package com.company.codingscales.leetcode.concepts.greedy;

import com.company.codingscales.templates.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganize(final String S) {
        final PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((curr, other) ->
                other.getSecond() - curr.getSecond());
        final HashMap<Character, Integer> hm = new HashMap<>();
        for (final char c : S.toCharArray()) {
            hm.putIfAbsent(c, 0);
            hm.put(c, hm.get(c) + 1);
        }

        for (final Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > (S.length() + 1) / 2) return "";
            pq.add(new Pair<Character, Integer>(entry.getKey(), entry.getValue()));
        }

        final StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            final Pair<Character, Integer> p1 = pq.poll();
            final Pair<Character, Integer> p2 = pq.poll();

            sb.append(p1.getFirst());
            sb.append(p2.getFirst());

            int x = p1.getSecond();
            int y = p2.getSecond();

            if (--x > 0) pq.add(new Pair<Character, Integer>(p1.getFirst(), x));
            if (--y > 0) pq.add(new Pair<Character, Integer>(p2.getFirst(), y));
        }

        if (pq.size() >= 1) sb.append(pq.poll().getFirst());

        return sb.toString();
    }

    public static void main(final String[] args) {
        System.out.println(reorganize("aab"));
        System.out.println(reorganize("aaba"));
    }
}
