package com.company.codingscales.leetcode.concepts.dynamicProgramming.fibanaciSeries;

public class MinJumpsToReach {
    static int[] dp;
    static int dfs(int index, int[] jumps) {
        if (index == jumps.length - 1)
            return 0;

        if (jumps[index] == 0)
            return Integer.MAX_VALUE;

        if (dp[index] != 0)
            return dp[index];

        int minimum = Integer.MAX_VALUE;
        for(int i = index + 1; i < index + jumps[index] + 1 && i < jumps.length; i++) {
            int val = dfs(i, jumps); // +1 for making that jump
            if (val != Integer.MAX_VALUE)
                minimum = Math.min(minimum, val + 1);
        }

        dp[index] = minimum;
        return minimum;
    }

    static int countMinJumps(int[] jumps) {
        dp = new int[jumps.length];
        return dfs(0, jumps);
    }

    static int countMinJumpsBottomUp(int[] jumps) {
        int[] dp = new int[jumps.length]; // you need to reach jumps.length th index.
        for(int i = 1; i < jumps.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < jumps.length - 1; i++) {
            for(int j = i + 1; j < i + jumps[i] + 1 && j < jumps.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[jumps.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(countMinJumps(new int[]{2, 1, 1, 1, 4}));
        System.out.println(countMinJumps(new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3}));

        System.out.println(countMinJumpsBottomUp(new int[]{2, 1, 1, 1, 4}));
        System.out.println(countMinJumpsBottomUp(new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3}));
    }
}
