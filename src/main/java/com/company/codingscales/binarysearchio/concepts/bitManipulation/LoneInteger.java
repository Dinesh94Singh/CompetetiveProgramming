package com.company.codingscales.binarysearchio.concepts.bitManipulation;

import java.util.Arrays;

public class LoneInteger {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ) {
            if (nums[i] == nums[i + 1]) {
                i = i + 3;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int solveWithBitManipulation(int[] nums) {
        int bit = 1;
        int res = 0;
        // for each bit digit
        for (int i = 0; i < 31; i++) {
            int count = 0;

            // for every number
            for (int n : nums) {
                if ((n & bit) != 0)
                    count += 1;
            }
            bit = bit << 1;
            if (count % 3 == 1)
                res += (1 << i);
        }

        return res;
    }
}
