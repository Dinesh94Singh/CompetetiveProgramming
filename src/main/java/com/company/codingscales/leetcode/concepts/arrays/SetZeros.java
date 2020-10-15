package com.company.codingscales.leetcode.concepts.arrays;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    for(int k = 0; k < R; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = Integer.MAX_VALUE;
                        else
                            matrix[k][j] = 0;
                    }

                    for(int k = 0; k < C; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = Integer.MAX_VALUE;
                        else
                            matrix[i][k] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = 0;
            }
        }
    }
}
