package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import com.company.codingscales.templates.PrintArray;

import java.util.Arrays;

public class JumpGame {
    enum Type {
        GOOD,
        BAD,
        UNKNOWN,
    }

    public static boolean canJump(final int[] nums) {
        if (nums.length == 1) return true;
        final Type[] memo = new Type[nums.length];
        Arrays.fill(memo, Type.UNKNOWN);
        memo[nums.length - 1] = Type.GOOD;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++){
                if (memo[j] == Type.GOOD) {
                    memo[i] = Type.GOOD;
                    break;
                }
            }
            if (memo[i] == Type.UNKNOWN)
                memo[i] = Type.BAD;
        }
        PrintArray.printArray(memo);
        return memo[0] == Type.GOOD;
    }

    private static boolean canJumpWithLinearTC(final int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) { // if you can reach lastPos, then you can reach the final destination.
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public boolean canJumpDP(int[] nums) {
        if (nums.length == 1)
            return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;


        for (int i = 1; i < dp.length; i++) {
            int j = i - 1;

            if (dp[i - 1] && j + nums[j] >= i) {
                for (int k = i; k < Math.min(dp.length, j + nums[j] + 1); k++)
                    dp[k] = true;
            }
        }

        return dp[dp.length - 1];
    }
    public static void main(final String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

}
