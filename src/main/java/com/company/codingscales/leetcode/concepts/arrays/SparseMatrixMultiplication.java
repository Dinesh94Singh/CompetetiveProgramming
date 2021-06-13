package com.company.codingscales.leetcode.concepts.arrays;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {
    public int[][] multiply(final int[][] A, final int[][] B) { // Matrix Mux normal
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

    static class SparseMatrix {
        int r, c;
        HashMap<Pair<Integer, Integer>, Integer> sparseMat;

        SparseMatrix() {
            this.sparseMat = new HashMap<>();
        }

        void convertToSparse(int[][] A) {
            int r = A.length;
            int c = A[0].length;

            this.r = r;
            this.c = c;

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if (A[i][j] != 0) {
                        sparseMat.put(new Pair<>(i, j), A[i][j]);
                    }
                }
            }
        }

        int[][] convertToRegular() {
            int[][] C = new int[r][c];

            for(Map.Entry<Pair<Integer, Integer>, Integer> entry : sparseMat.entrySet()) {
                int r = entry.getKey().getKey();
                int c = entry.getKey().getValue();
                int v = entry.getValue();

                C[r][c] = v;
            }

            return C;
        }
    }

    int[][] multiplyWithSparse(int[][] A, int[][] B) throws Exception {
        SparseMatrix sA = new SparseMatrix();
        sA.convertToSparse(A);

        SparseMatrix sB = new SparseMatrix();
        sB.convertToSparse(B);

        SparseMatrix sC = new SparseMatrix();
        if (sA.c != sB.r) {
            // invalid input
            throw new Exception("Invalid input provided");
        }

        sC.r = sA.r; // as per mux rules
        sC.c = sB.c;

        for(Map.Entry<Pair<Integer, Integer>, Integer> eA : sA.sparseMat.entrySet()) {
            int aR = eA.getKey().getKey();
            int aC = eA.getKey().getValue();
            int aV = eA.getValue();

            for(int bC = 0; bC < sB.c; bC++) {
                Pair<Integer, Integer> key = new Pair<>(aC, bC);
                if (sB.sparseMat.containsKey(key)) {
                    // if similar (r,c) exists => do dot prod
                    int bV = sB.sparseMat.get(key);

                    // add to res
                    sC.sparseMat.put(new Pair<>(aR, bC), sC.sparseMat.getOrDefault(new Pair<>(aR, bC), 0) + (aV * bV)); // sigma
                }
            }
        }

        return sC.convertToRegular();
    }

    public static void main(String[] args) throws Exception {
        SparseMatrixMultiplication smx = new SparseMatrixMultiplication();
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] C = smx.multiplyWithSparse(A, B);


        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < C[0].length; j++) {
                System.out.print("At " + i + ", " + j + " => " + C[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
