package com.company.codingscales.contests;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        System.out.println(solveKnapsack(new int[]{2, 3, 1, 4}, new int[] {4, 5, 3, 7}, 5));
        System.out.println(subsetSumEqualPartition(new int[]{1, 2, 3, 4}));
    }

    public static int solveKnapsack(int[] weights, int[] profits, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];
        int ans = 0;


        // dp[i][j] represents max profit that can be achieved when capacity is j using i weights

        for (int i = 0; i <= capacity; i++) {
            if (i >= weights[0])
                dp[0][i] = profits[0];
        }

        for (int i = 1; i < profits.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int maxProfit = 0;
                if (weights[i] <= j) {
                    // if you add
                    maxProfit = profits[i] + dp[i - 1][j - weights[i]];
                }
                maxProfit = Math.max(maxProfit, dp[i - 1][j]);

                dp[i][j] = maxProfit;
                ans = Math.max(maxProfit, ans);
            }
        }

        return ans;
    }

    static boolean subsetSumEqualPartition(int[] num) {
        int total = Arrays.stream(num).reduce(0, Integer::sum);
        if (total % 2 != 0)
            return false;

        int capacity = total / 2;
        int n = num.length;
        boolean[][] dp = new boolean[n][capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            if (num[0] <= i) {
                dp[0][i] = true;
            }
        }

        for (int i = 1 ; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] |= dp[i-1][j] || (j >= num[i] && dp[i - 1][j - num[i]]);
            }
        }

        return dp[n - 1][capacity];
    }
}
