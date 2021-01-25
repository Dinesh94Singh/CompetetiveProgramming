package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

import java.util.Arrays;

public class MaximalSquare {
    private static int recHelper(final char[][] matrix, final int i, final int j, final int[][] cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (matrix[i][j] == '0') {
            cache[i][j] = 0;
            return cache[i][j];
        }

        final int total = 1 + Math.min(Math.min(recHelper(matrix, i - 1, j, cache) , recHelper(matrix, i - 1, j - 1, cache)), recHelper(matrix, i, j - 1, cache));
        cache[i][j] = total;
        return total;
    }

    public static int maximalSquare(final char[][] matrix) {
        final int R = matrix.length;
        final int C = R > 0 ? matrix[0].length : 0;
        int maximum = Integer.MIN_VALUE;
        final int[][] cache = new int[R][C];
        for(final int[] a : cache) {
            Arrays.fill(a, -1);
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (matrix[i][j] == '1') {
                    maximum = Math.max(maximum, recHelper(matrix, i, j, cache));
                }
            }
        }

        return maximum * maximum; // since its a square
    }

    public static int maximalSquareDp(final char[][] matrix) {
        final int R = matrix.length;
        final int C = R > 0 ? matrix[0].length : 0;
        int maximum = Integer.MIN_VALUE;
        final int[][] cache = new int[R + 1][C + 1];
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    cache[i][j] = Math.min(Math.min(cache[i-1][j], cache[i][j-1]), cache[i-1][j-1]) + 1;
                    maximum = Math.max(maximum, cache[i][j]);
                }
            }
        }
        return maximum * maximum;
    }

    public static void main(final String[] args) {
        final char[][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}
