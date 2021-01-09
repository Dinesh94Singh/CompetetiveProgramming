package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

import java.util.List;

public class Triangle {
    int minimumTotal(List<List<Integer>> triangle) { // O(M*N) sol
        int[][] directions = {{1, 0}, {1, 1}};
        int M = triangle.size();
        for (int i = M - 2; i >= 0; i--) {
            int N = triangle.get(i).size();
            for (int j = 0; j < N; j++) {
                int minimum = Integer.MAX_VALUE;

                for (int[] each : directions) {
                    int r = each[0] + i;
                    int c = each[1] + j;

                    if (r < 0 || r >= M || c < 0 || c >= N)
                        continue;

                    minimum = Math.min(minimum, triangle.get(r).get(c));
                }

                triangle.get(i).set(j, minimum + triangle.get(i).get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    int minimumTotalConcise(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                List<Integer> nextRow = triangle.get(i + 1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
