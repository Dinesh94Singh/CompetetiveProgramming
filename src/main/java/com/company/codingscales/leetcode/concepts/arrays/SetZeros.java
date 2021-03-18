package com.company.codingscales.leetcode.concepts.arrays;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < R; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = Integer.MAX_VALUE;
                        else
                            matrix[k][j] = 0;
                    }

                    for (int k = 0; k < C; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = Integer.MAX_VALUE;
                        else
                            matrix[i][k] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = 0;
            }
        }
    }

    public void setZerosWithNegativeNumbers(int[][] matrix) {
        int R = matrix.length;
        int C = R > 0 ? matrix[0].length : 0;

        boolean isRow = false;
        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 0)
                isRow = true;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++)
                matrix[0][j] = 0;
        }

        if (isRow) {
            for (int i = 0; i < R; i++)
                matrix[i][0] = 0;
        }
    }
}
