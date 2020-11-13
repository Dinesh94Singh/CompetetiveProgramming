package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.stream.Stream;

public class MinimumFallingPathSum {
    Integer[][] cache;
    int R, C;
    public int minFallingPathSum(int[][] A) {
        R = A.length;
        C = A[0].length;
        cache = new Integer[R][C];

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < C; i++) {
            res = Math.min(res, dfs(A, 0, i));
        }
        return res;
    }
    private int dfs(int[][] A, int row, int col) {
        if (row == R - 1)
            return A[row][col];
        if (null != cache[row][col])
            return cache[row][col];

        if(0 == col) {
            int res = A[row][col] + Math.min(dfs(A, row + 1, col), dfs(A, row + 1, col + 1));
            cache[row][col] = res;
            return res;
        }

        if(C - 1 == col) {
            int res = A[row][col] + Math.min(dfs(A, row + 1, col), dfs(A, row + 1, col - 1));
            cache[row][col] = res;
            return res;
        }
        int c1 = dfs(A, row + 1, col);
        int c2 = dfs(A, row + 1, col - 1);
        int c3 = dfs(A, row + 1, col + 1);
        int res = Stream.of(c1, c2, c3).min(Integer::compare).get();
        cache[row][col] = A[row][col] + res;
        return cache[row][col];
    }
}
