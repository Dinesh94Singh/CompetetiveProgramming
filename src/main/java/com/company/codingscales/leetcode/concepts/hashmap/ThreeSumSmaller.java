package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] A, int target) {
        Arrays.sort(A);

        int closestValue = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 0; i < A.length - 2; i++) {
            int lo = i + 1;
            int hi = A.length - 1;

            while (lo < hi) {
                int total = A[i] + A[lo] + A[hi];

                if (total < target) {
                    count+= (hi - lo); // all the elements within the range are also smaller
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return count;
    }
}
