package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

/**
 * +-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
 * |     | |       |     |        |     |     |     |         |     |     |        |
 * |     | |       |     |        |     |     |     |         |     |     |        |
 * +-----+-+       |     +--------+     |     |     |         |     +-----+        |
 * |     | |       |  =  |              |  +  |     |         |  -  |              | + mat[i][j]
 * +-----+-+       |     |              |     +-----+         |     |              |
 * |               |     |              |     |               |     |              |
 * |               |     |              |     |               |     |              |
 * +---------------+     +--------------+     +---------------+     +--------------+
 *
 * rangeSum[i+1][j+1] =  rangeSum[i][j+1]  +   rangeSum[i+1][j]  -   rangeSum[i][j]  + mat[i][j]
 *
 * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
 * |               |   |         |    |   |   |           |   |         |    |   |   |          |
 * |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
 * |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
 * |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
 * |   |      |    |   |         |    |   |   |           |   |              |   |              |
 * |   +------+    |   +---------+    |   +---+           |   |              |   |              |
 * |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
 * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] A, int K) {
        int m = A.length;
        int n = A[0].length;

        int[][] prefixSum = new int[m + 1][n + 1];
        // prefixSum[0][i] for i in range (0, m) will be 0 as a base case.
        // prefixSum[i][0] for i in range (0, n) will be 0 as a base case.

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + A[i][j];
            }
        }

        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - K);
                int c1 = Math.max(0, j - K);

                int r2 = Math.min(m, i + K + 1);
                int c2 = Math.min(n, j + K + 1);

                res[i][j] = prefixSum[r2][c2] - prefixSum[r2][c1] - prefixSum[r1][c2] + prefixSum[r1][c1];
            }
        }

        return res;
    }
}
