package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.HashMap;

public class LongestIncreasingPathInMatrix {
    int R, C;
    final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dfs(final int i, final int j, final int[][] matrix, final HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (map.containsKey(i)) {
            if (map.get(i).containsKey(j)) {
                return map.get(i).get(j);
            }
        }

        int res = 1;
        for (int[] each : directions) {
            int x = each[0] + i;
            int y = each[1] + j;
            if (0 <= x && x < R && 0 <= y && y < C && matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dfs(x, y, matrix, map) + 1);
            }
        }
        map.putIfAbsent(i, new HashMap<Integer, Integer>());
        map.get(i).put(j, res);
        return res;
    }

    public int longestIncreasingPath(final int[][] matrix) {
        // brute force solution is O(n^4)
        // one way to overcome the bottle neck is to save the progress till [i.j]
        R = matrix.length;
        C = R > 0 ? matrix[0].length : 0;

        final HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res = Math.max(res, dfs(i, j, matrix, map));
            }
        }
        return res;
    }
}
