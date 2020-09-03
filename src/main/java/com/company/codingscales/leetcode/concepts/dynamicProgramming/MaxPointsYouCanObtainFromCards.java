package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.Arrays;

public class MaxPointsYouCanObtainFromCards {
    // time limit exceeded
    private static int recHelper(final int startIdx, final int endIdx, final int[] arr, final int k, final int total, final int[][] cache) {
         if (startIdx == arr.length || endIdx == -1)
             return 0;

         if (cache[startIdx][endIdx] != -1) {
             return cache[startIdx][endIdx];
         }

         if (k == 0) {
             return total;
         }

         int m = Integer.MIN_VALUE;
         m = Math.max(m, recHelper(startIdx + 1, endIdx, arr, k - 1, total + arr[startIdx], cache));
         m = Math.max(m, recHelper(startIdx, endIdx - 1, arr, k - 1, total + arr[endIdx], cache));
         cache[startIdx][endIdx] = m;
         return m;
     }

    public static int maxScore(final int[] cardPoints, final int k) {
         final int[][] cache = new int[cardPoints.length][cardPoints.length];
         for(final int[] a : cache) {
             Arrays.fill(a, -1);
         }

         return recHelper(0, cardPoints.length - 1, cardPoints, k, 0, cache);
    }

    /**
     * Sliding window
     * Swap leftCard and RightCard
     * https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
     */
    public static int maxScoreLinear(final int[] arr, final int k) {
        int leftSum = 0;
        int rightSum = 0;
        final int n = arr.length;

        for(int i = 0; i < k ; i++) {
            leftSum += arr[i];
        }

        int res = leftSum;

        // swap ith card with n-k-ith card
        for(int i = 0; i < k; i++) {
            leftSum = leftSum - arr[k - i - 1];
            rightSum = rightSum + arr[n - i - 1];

            res = Math.max(res, leftSum + rightSum); // replace leftSum with rightCard
        }

        return res;
    }

    public static int maxScoreLinearPrefixSum(final int[] a, final int k) {
        final int n = a.length;
        final int[] cum = new int[n+1];
        for(int i = 0;i < n;i++)cum[i+1] = cum[i] + a[i];
        int ans = 0;
        for(int i = 0;i <= k;i++){
            ans = Math.max(ans, cum[i] + cum[n] - cum[n-k+i]);
        }
        return ans;
    }


    public static void main(final String[] args) {
        System.out.println(maxScore(LeetCodeInputHelpers.stringToIntArray("[1,2,3,4,5,6,1]"), 3));
    }
}
