package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

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

    private int dfs(int[][] A, int r, int c) {
        if (r == R - 1)
            return A[r][c];
        if (null != cache[r][c])
            return cache[r][c];

        if(c == 0) {
            int res = A[r][c] + Math.min(dfs(A, r + 1, c), dfs(A, r + 1, c + 1));
            cache[r][c] = res;
            return res;
        }

        if(c == C - 1) {
            int res = A[r][c] + Math.min(dfs(A, r + 1, c), dfs(A, r + 1, c - 1));
            cache[r][c] = res;
            return res;
        }
        int c1 = dfs(A, r + 1, c);
        int c2 = dfs(A, r + 1, c - 1);
        int c3 = dfs(A, r + 1, c + 1);
        int res = Stream.of(c1, c2, c3).min(Integer::compare).get();
        cache[r][c] = A[r][c] + res;
        return cache[r][c];
    }

    public int minFallingPathSumBottomUp(int[][] A) {
        int N = A.length;
        for (int r = N-2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c];
                if (c > 0)
                    best = Math.min(best, A[r+1][c-1]);
                if (c+1 < N)
                    best = Math.min(best, A[r+1][c+1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }
}
