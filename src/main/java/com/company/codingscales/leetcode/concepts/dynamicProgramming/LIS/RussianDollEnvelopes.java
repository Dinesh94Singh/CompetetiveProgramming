package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.Arrays;

/**
 * Similar to {@link LongestIncreasingSubsequence}
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] A) {
        int N = A.length;
        if (N == 0)
            return 0;

        int[] dp = new int[N];

        Arrays.sort(A, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        Arrays.fill(dp, 1);

        int res = Integer.MIN_VALUE;

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                int w1 = A[i][0];
                int h1 = A[i][1];

                int w2 = A[j][0];
                int h2 = A[j][1];

                if ((w1 < w2 && h1 < h2) || (w1 > w2 && h1 > h2)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        if (res == Integer.MIN_VALUE)
            return 1;

        return res;
    }
}
