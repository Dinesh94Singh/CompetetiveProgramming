package com.company.codingscales.leetcode.concepts.arrays;

public class FindKthMissingElement {
    public int findKthMissingElements(int[] arr, int k) {
        int missingElements = 0;
        int start = 1;
        int startIdx = 0;

        int gap = arr[0] - 1;

        if (gap >= k) {
            return start + k - 1;
        } else if (gap > 0) {
            start = arr[0];
            missingElements += gap;
            startIdx = 1;
        }

        for(int i = startIdx; i < arr.length; i++) {
            int each = arr[i];
            gap = each - start - 1;

            if (gap > 0) {
                if (missingElements <= k && k <= missingElements + gap) {
                    return start + k - missingElements;
                } else {
                    missingElements += gap;
                }
            }

            start = each;
        }

        return arr[arr.length - 1] + k - missingElements;
    }
}
