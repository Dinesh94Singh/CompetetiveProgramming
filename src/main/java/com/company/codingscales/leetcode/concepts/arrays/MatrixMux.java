package com.company.codingscales.leetcode.concepts.arrays;

public class MatrixMux {
    public static void main(final String[] args) {
        final int r1 = 2, c1 = 3;
        final int r2 = 3, c2 = 2;

        final int[][] firstMatrix = { {3, -2, 5}, {3, 0, 4} };
        final int[][] secondMatrix = { {2, 3}, {-9, 0}, {0, 4} };

        // Mux Two matrices
        final int[][] product = multiplyMatrices(firstMatrix, secondMatrix, r1, c1, c2);
    }

    public static int[][] multiplyMatrices(final int[][] firstMatrix, final int[][] secondMatrix, final int r1, final int c1, final int c2) {
        final int[][] product = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }
}
