package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

public class RangeSumQuery2DImmutable {
    int[][] prefixSum;
    int R, C;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        R = matrix.length;
        C = R > 0 ? matrix[0].length : 0;

        prefixSum = new int[R + 1][C + 1];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return prefixSum[r2 + 1][c2 + 1] - prefixSum[r1][c2 + 1] - prefixSum[r2 + 1][c1] + prefixSum[r1][c1];
    }
}
