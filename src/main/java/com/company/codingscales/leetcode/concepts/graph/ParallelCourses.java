package com.company.codingscales.leetcode.concepts.graph;

import java.util.*;

/**
 * ParallelCourses
 */
public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for (int[] e : relations) {
            int prev = e[0];
            int next = e[1];

            map.get(prev).add(next);
            inDegree.put(next, inDegree.getOrDefault(next, 0) + 1);
        }

        // { 1 : [3], 2: [3], 3: []}

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                dq.offerLast(entry.getKey());
            }
        }

        int level = 0;
        int count = 0;
        while(dq.size() > 0) {
            int t = dq.size();

            for (int i = 0; i < t; i++) {
                int x = dq.pollFirst(); // i can take this course
                count++;

                for (int nei : map.get(x)) {
                    inDegree.put(nei, inDegree.get(nei) - 1);

                    if (inDegree.get(nei) == 0) {
                        dq.offerLast(nei);
                    }
                }
            }

            level++;
        }


        if (count != n)
            return -1;

        return level;
    }

}
