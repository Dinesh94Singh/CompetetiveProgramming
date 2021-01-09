package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

import java.util.Arrays;

/**
 * Can use A* alg to move from (0,0) till (m,n) and find the path => TC for this would beO(MNLog(MN))
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] A) {
        int M = A.length;
        int N = A[0].length;

        int[][] hp = new int[M + 1][N + 1];

        for(int[] row : hp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Queen is at (M, N). To reach (M, N), you need to either come from (M-1, N) or (M, N-1)
        hp[M - 1][N] = 1;
        hp[M][N - 1] = 1;

        for(int i = M - 1; i >= 0; i--) {
            for(int j = N - 1; j >= 0; j--) {
                int need = Math.min(hp[i + 1][j], hp[i][j + 1]) - A[i][j];
                hp[i][j] = need > 0 ? need : 1; // minimum of 1 health is required.
            }
        }

        return hp[0][0];
    }
}
