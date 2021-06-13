package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class MinimumAsciiDeleteSumToTwoStrings {
    int dfs(String A, String B, int i, int j) {
        if (i == A.length() && j == B.length())
            return 0;

        if (i == A.length())
            return B.charAt(j) + dfs(A, B, i, j + 1);
        if (j == B.length())
            return A.charAt(j) + dfs(A, B, i + 1, j);

        if (A.charAt(i) == B.charAt(j)) {
            return dfs(A, B, i + 1, j + 1);
        }

        return Math.min(A.charAt(i) + dfs(A, B, i + 1, j), B.charAt(j) + dfs(A, B, i, j + 1));
    }

    public int minimumDeleteSum(String A, String B) {
        int M = A.length();
        int N = B.length();

        int[][] dp = new int[M+1][N+1];

        // Similar to Edit Distance where dp[0][i] = i; and dp[i][0] = i;
        for(int i = 1; i <= N; i++)
            dp[0][i] = dp[0][i - 1] + B.charAt(i - 1);

        for(int i = 1; i <= M; i++)
            dp[i][0] = dp[i - 1][0] + A.charAt(i - 1);


        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {

                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    int costToDeleteFromA = dp[i-1][j] + A.charAt(i - 1);
                    int costToDeleteFromB = dp[i][j-1] + B.charAt(j - 1);

                    dp[i][j] = Math.min(costToDeleteFromA, costToDeleteFromB);
                } else {
                    dp[i][j] = dp[i-1][j-1]; // no delete cost
                }
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
        MinimumAsciiDeleteSumToTwoStrings sol = new MinimumAsciiDeleteSumToTwoStrings();
        System.out.println(sol.minimumDeleteSum("sea", "eat"));
    }
}
