package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] A, int target) {
        int diff = Integer.MAX_VALUE, N = A.length;
        Arrays.sort(A);
        for (int i = 0; i < N && diff != 0; ++i) { // even if there are duplicates, the diff is going to be the same.
            int lo = i + 1, hi = N - 1;
            while (lo < hi) {
                int sum = A[i] + A[lo] + A[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    ++lo;
                else
                    --hi;
            }
        }
        return target - diff;
    }
}
