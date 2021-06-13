package com.company.codingscales.interviews.goldmansachs;

import java.util.Arrays;

public class DeleteAndEarn {
    long[] memo;
    long maxPoints(int[] A) {
        Arrays.sort(A); // sorting will help us to not consider about deleting A[idx] - 1 val
        // We don't consider A[idx] - 1 val, because, they are part of memo
        memo = new long[A.length];
        Arrays.fill(memo, -1);
        return dfs(A,0,memo);
    }

    long dfs(int[] A, int idx, long[] memo) {
        if (idx == A.length)
            return 0;
        if (memo[idx] != -1) {
            return memo[idx];
        }

        long earned = A[idx];
        int skipIdx = idx + 1;
        // if similar values, just move to the point, where the skipIdx should be
        while (skipIdx < A.length && A[skipIdx] == A[idx]) {
            earned += A[skipIdx];
            skipIdx++;
        }

        // remove all elemnts which are A[idx] + 1 val
        while (skipIdx < A.length && A[skipIdx] == A[idx] + 1) {
            skipIdx++;
        }

        earned += dfs(A, skipIdx, memo);

        long earnedBySkipping = dfs(A, idx + 1, memo);
        memo[idx] = Math.max(earned, earnedBySkipping);
        return memo[idx];
    }

    long maxPointsDP(int[] A) {
        // forget about A[i] + 1
        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];

        Arrays.sort(A);

        int[] dp = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            dp[i] = A[i];
        }

        int res = 0;

        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if (A[i] == A[j] || A[i] > A[j] + 1) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                    res = Math.max(res, dp[i]);
                }
            }
        }


        return res;
    }
}
