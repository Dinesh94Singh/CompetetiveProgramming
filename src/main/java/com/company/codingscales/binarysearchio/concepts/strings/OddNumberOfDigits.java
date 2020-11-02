package com.company.codingscales.binarysearchio.concepts.strings;

public class OddNumberOfDigits {
    // TODO: Refer to this trick, before interviews - https://practice.geeksforgeeks.org/tracks/DSASP-Mathematics/?batchId=154
    public int solve(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((int) (Math.log10(num) + 1) % 2 == 1)
                count++;
        }
        return count;
    }

    public int solveConvertingToString(int[] nums) {
        int count = 0;
        for(int a : nums) {
            if (String.valueOf(a).length() % 2 != 0)
                count++;
        }

        return count;
    }
}
