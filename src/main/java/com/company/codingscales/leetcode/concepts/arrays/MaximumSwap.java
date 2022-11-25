package com.company.codingscales.leetcode.concepts.arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i; // record the last occurence
        }

        /**
         1. Record all the last occurences
         2. Reiterate and see, if there is a largest number than the number at ith idx and occurs after the current idx. => if you found one, swap and return
         **/

        // 1091 => 1 --> find the number from 9 --- > 1 => 9011 (res) // only one swap allowed
        for (int i = 0; i < digits.length; i++) { // try to see, if 0, exisits
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
