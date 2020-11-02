package com.company.codingscales.binarysearchio.concepts.bitManipulation;

public class PigeonHole {
    public int solve(int[] nums) {
        int xor = nums.length;
        for(int i = 0; i < nums.length; i++) {
            xor ^= (i + 1);
            xor ^= nums[i];
        }

        return xor;
    }
}
