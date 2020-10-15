package com.company.codingscales.leetcode.concepts.arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;

        int N = nums.length;
        final int[] prefix = new int[nums.length];
        final int[] suffix = new int[nums.length];

        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        suffix[0] = nums[N - 1];
        for(int i = 1; i < nums.length; i++) {
            suffix[i] = suffix[i - 1] + nums[N - i - 1];
        }

        // Arrays.stream(prefix).forEach(e -> System.out.printf("%d \t", e));
        // System.out.println("\n");
        // Arrays.stream(suffix).forEach(e -> System.out.printf("%d \t", e));
        // System.out.println("\n");

        for(int i = 0; i < N; i++) {
            if (prefix[i] == suffix[N - i - 1])
                return i;
        }

        return -1;
    }
}
