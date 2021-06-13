package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class MinimumDifficultyOfJobSchedule {
    // schedule jobs in d days
    // min of 1 task needs to be finished
    // Difficult of Job Scheduler is total of each day's difficulties, where =>
    // difficulty of day => max diff job done in that day
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;

        if (N < d)
            return -1;


        return dfs(0, d, jobDifficulty);
    }

    static int dfs(int index, int d, int[] A) {
        int N = A.length;
        if (index == N)
            return 0;

        if (d == 1) { // last day
            int maximum = Integer.MIN_VALUE;
            for (int k = index; k < N; k++) { // what ever left in A's maxDifficulty, is the day's difficulty
                maximum = Math.max(maximum, A[k]);
            }

            return maximum;
        }

        int maximum = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        for(int k = index; k < N - d + 1; k++) { // stop at idx k and get maxDifficulty for the day and hope next days difficult is easier. You must and should do, 1 work at-least per day.
            maximum = Math.max(maximum, A[k]);
            res = Math.min(res, maximum + dfs(k + 1, d - 1, A)); // cut at this index and add the sum of maximum
        }

        return res;
    }

    static int minDifficultyBottomUp(int[] A, int D) {
        int n = A.length, inf = Integer.MAX_VALUE, maxForDay_d;
        if (n < D) return -1;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], A[i]);
        for (int d = 2; d <= D; ++d) {
            for (int i = 0; i <= n - d; ++i) {
                maxForDay_d = 0;
                dp[i] = inf;
                for (int j = i; j <= n - d; ++j) {
                    maxForDay_d = Math.max(maxForDay_d, A[j]);
                    dp[i] = Math.min(dp[i], maxForDay_d + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2);
    }
}
