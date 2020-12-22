package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.Arrays;

public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int N = pairs.length;
        if (N == 0)
            return 0;

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int res = 1;

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int[] b = pairs[i];
                int[] a = pairs[j];
                if (a[1] < b[0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}
