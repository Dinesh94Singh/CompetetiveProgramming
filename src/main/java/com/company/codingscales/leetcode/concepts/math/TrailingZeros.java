package com.company.codingscales.leetcode.concepts.math;

public class TrailingZeros {
    public int trailingZeroes(int n) {
        // count num of 2's and 5's
        // number of 2's always > 5's ?? every 2 numbers is a factor of 2 (coz even number)
        // factors of 5 are 5, 25, 75, ....

        int count = 0;

        int multiple = 5;

        while (n >= multiple) {
            count += (n / multiple);
            multiple *= 5;
        }

        return count;
    }
}
