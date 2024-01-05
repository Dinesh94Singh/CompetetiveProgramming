public package com.company.codingscales.leetcode.concepts.bfs;

import java.util.*;

class DetonateTheMaximumBombs {

    public int maximumDetonation(int[][] bombs) {
        // Given list of bombs, I am allowed to start bombing only one
        // Try each bomb and see what it the maximum bombs it can blow

        int N = bombs.length;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                int[] A = bombs[i];
                int[] B = bombs[j];

                int x1 = A[0];
                int x2 = B[0];

                int y1 = A[1];
                int y2 = B[1];

                long dist = (long) (x1 - x2) * (long) (x1 - x2) + (long) (y1 - y2) * (long) (y1 - y2);
                long radius = (long) A[2] * (long) A[2];

                if (radius >= dist) {
                    if (!graph.containsKey(i)) {
                        graph.put(i, new ArrayList<>());
                    }

                    graph.get(i).add(j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dfs(i, graph));
        }

        return res;
    }


    private int dfs(int cur, HashMap<Integer, ArrayList<Integer>> graph) {
        Set<Integer> seen = new HashSet<>();
        seen.add(cur);
        int count = 1;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(cur);

        while (!dq.isEmpty()) {
            int n = dq.size();

            for (int i = 0; i < n; i++) {
                int t = dq.pollFirst();
                for (int nei : graph.getOrDefault(t, new ArrayList<>())) {
                    if (!seen.contains(nei)) {
                        count++;
                        seen.add(nei);
                        dq.offerLast(nei);
                    }
                }
            }
        }

        return seen.size();
    }
}
