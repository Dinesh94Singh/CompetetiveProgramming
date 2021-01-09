package com.company.codingscales.leetcode.concepts.dynamicProgramming.minimax;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.Arrays;

public class PredictTheWinner {
    private int recHelper(int[] nums, int firstIndex, int lastIndex, int turn, int[][] cache) {
        if (nums.length == 0) { return 0; }

        if (firstIndex == lastIndex) { return nums[firstIndex]; }

        if (cache[firstIndex][lastIndex] != -1) { return cache[firstIndex][lastIndex]; }

        int firstChoice = turn * nums[firstIndex] + recHelper(nums, firstIndex + 1, lastIndex, -turn, cache);
        int lastChoice = turn * nums[lastIndex] + recHelper(nums, firstIndex, lastIndex - 1, -turn, cache);


        cache[firstIndex][lastIndex] = turn * Math.max(turn * firstChoice, turn * lastChoice);
        return cache[firstIndex][lastIndex];
    }

    public boolean PredictTheWinner(int[] nums) {
        int[][] cache = new int[nums.length][nums.length];

        for(int[] a : cache) {
            Arrays.fill(a, -1);
        }

        return recHelper(nums, 0, nums.length - 1, 1, cache) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(LeetCodeInputHelpers.stringToIntArray("[1,5,2]"));
    }
}
