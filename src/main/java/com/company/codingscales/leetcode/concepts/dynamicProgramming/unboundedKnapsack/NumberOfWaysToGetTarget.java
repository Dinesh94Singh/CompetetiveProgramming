package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

import java.util.HashMap;

public class NumberOfWaysToGetTarget {
    HashMap<Integer, Integer> map = new HashMap<>();
    public static int solve(int k, int target) {
        int[] A = new int[k];
        for (int i = 1; i <= k; i++) {
            A[i - 1] = i;
        }

        return dp(A, 0, target);
    }

    private static int dp(int[] A, int i, int target) {
       if (target == 0)
           return 1;
       if (A.length == i)
           return 0;
       if (A[i] > target)
           return 0;

       int ways = 0;
       for (int j = i; j < A.length; j++) {
           if (A[i] <= target) {
               ways += dp(A, j, target - A[i]);
           } else {
               break;
           }
       }

       ways += dp(A, i + 1, target);
        /**
         * 4 - >
         *  1,1,1,1
         *  1,1,2
         *  2,1,1
         *  1,2,1
         *  2,2
         */
       return ways;
    }
    public static void main(String[] args) {
        System.out.println(solve(2, 4));
    }
}
