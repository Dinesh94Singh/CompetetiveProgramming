package com.company.codingscales.leetcode.concepts.arrays;

public class MaximalRectangle {
    public int maximalRectangle(final char[][] matrix) {
        final int R = matrix.length;
        final int C = R > 0 ? matrix[0].length : 0;

        final int[][] m = new int[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(matrix[i][j] == '1') {
                    m[i][j] = 1;
                }
            }
        }

        int largestArea = Integer.MIN_VALUE;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (i > 0 && m[i][j] == 1)
                    m[i][j] += m[i-1][j];
            }

            largestArea = Math.max(largestArea, maximumAreaOfHistograms(m[i]));
        }

        if (largestArea == Integer.MIN_VALUE)
            return 0;

        return largestArea;
    }

    static int maximumAreaOfHistograms(final int[] m) {
        return LargestAreaOfRectangle.largestRectangleArea(m);
    }
}
