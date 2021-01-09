package com.company.codingscales.leetcode.concepts.dynamicProgramming.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestArthimeticSequence {
    // dp[index][diff] equals to the length of arithmetic sequence at index with difference diff.
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        HashMap<Integer, Integer>[] dp = new HashMap[n]; // prefer List<HashMap<I, I>> instead
        int res = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++) {
            dp[j] = new HashMap<>();
            for(int i = 0; i < j; i++) {
                int diff = A[j] - A[i];
                dp[j].put(diff, dp[i].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[j].get(diff));
            }
        }

        return res;
    }
}
