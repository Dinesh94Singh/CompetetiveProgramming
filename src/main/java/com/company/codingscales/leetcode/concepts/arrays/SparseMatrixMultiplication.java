package com.company.codingscales.leetcode.concepts.arrays;

public class SparseMatrixMultiplication {
    public int[][] multiply(final int[][] A, final int[][] B) {
        final int r1 = A.length;
        final int c1 = A[0].length;

        final int r2 = B.length;
        final int c2 = B[0].length;

        if (c1 != r2)
            return new int[0][0]; // mat mux not possible

        final int C[][] = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                if (A[i][j] == 0)
                    continue;
                for (int k = 0; k < c1; k++) {
                    if (B[k][j] != 0) {
                        C[j][k] += A[i][j] * B[k][j];
                    }
                }
            }
        }

        return C;
    }
}
