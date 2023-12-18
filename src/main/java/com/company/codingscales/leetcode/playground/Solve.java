package com.company.codingscales.leetcode.playground;

import javafx.util.Pair;

import java.util.*;

public class Solve {
    private static List<Integer> solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair<>(entry.getKey(), entry.getValue()));
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && pq.size() >= 2) {
            System.out.println(pq);
            Pair<Integer, Integer> first = pq.poll();
            Pair<Integer, Integer> second = pq.poll();

            int t = first.getValue() + second.getValue() / 2; // 3 + 1 / 2 => 3 + 0
            res.add(t);

            if (second.getValue() / 2 > 0) {
                pq.offer(new Pair<>(second.getKey(), second.getValue() / 2));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solve sol = new Solve();

        System.out.println("Hello, World!");
        List<Integer> l = solve(new int[]{6,6,6,1,2});

        System.out.printf("Result !!");
        for (int each : l) {
            System.out.println(each);
        }
    }
}
