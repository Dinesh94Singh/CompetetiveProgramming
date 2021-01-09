package com.company.codingscales.leetcode.concepts.dynamicProgramming.matrixMux;

public class MinimumScoreTriangulationOfPolygon {
    // Prefer this solution
    public int minScoreTriangulation(int[] A) {
        int N = A.length;

        /*
            From a N vertex Polygon, we can form N-2 Triangles
        */

        int[][] dp = new int[N][N];
        for(int length = 2; length < N; length++) {
            for (int left = 0; left + length < N; left++) {
                int right = left + length;
                dp[left][right] = Integer.MAX_VALUE;

                for(int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.min(dp[left][right], A[left] * A[right] * A[k] + dp[left][k] + dp[k][right]);
                }
            }
        }

        return dp[0][N - 1];
    }

    public int minScoreTriangulationAnotherSol(int[] A) {
        int n = A.length;

        int[][] dp = new int[n][n];
        // Where does the idea of DP come from, in order to triangulate a polygon formed as a sub-polygon -> instead of recalculating it, we store the res

        for(int right = 2; right < n; right++) { // since n - 2 triangles at max, start with 2 side and triangulate that part and move forward
            for(int left = right - 2; left >= 0; left--) { // min of 3 sides required => ith (j), i-1(varying k)th and i-2(i)th
                dp[left][right] = Integer.MAX_VALUE;

                for(int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.min(dp[left][right], A[left] * A[right] * A[k] + dp[left][k] + dp[k][right]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
