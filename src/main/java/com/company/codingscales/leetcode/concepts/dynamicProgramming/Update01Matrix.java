package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class Update01Matrix {
    // similar to walls and gate LC problem
    public int[][] updateMatrixWithBFS(final int[][] matrix) {
        final int R = matrix.length;
        final int C = R > 0 ? matrix[0].length : 0;

        final Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        final int[][] dirs = {{ 0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            final int[] curr = queue.poll();
            for(int[] d : dirs) {
                final int r = curr[0] + d[0];
                final int c = curr[1] + d[1];

                if (r < 0 || r >= R || c < 0 || c >= C || matrix[r][c] <= matrix[curr[0]][curr[1]] + 1)
                    continue;

                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
            }
        }

        return matrix;
    }

    public int[][] updateMatrixDP(final int[][] matrix) {
        final int R = matrix.length;
        final int C = R > 0 ? matrix[0].length : 0;

        final int[][] dp = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    final int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    final int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;

                    if (up == Integer.MAX_VALUE && left == Integer.MAX_VALUE)
                        dp[i][j] = Integer.MAX_VALUE;
                    else
                        dp[i][j] = Math.min(up, left) + 1;
                }
            }
        }


        for(int i = R - 1; i >= 0; i--) {
            for(int j = C - 1; j >= 0; j--) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    final int down = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    final int right = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;

                    if (down == Integer.MAX_VALUE && right == Integer.MAX_VALUE)
                        dp[i][j] = Integer.MAX_VALUE;
                    else
                        dp[i][j] = Math.min(down, right) + 1;
                }
            }
        }

        return dp;
    }
}
