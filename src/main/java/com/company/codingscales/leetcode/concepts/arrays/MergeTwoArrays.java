package com.company.codingscales.leetcode.concepts.arrays;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class MergeTwoArrays {
    public static void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(final String[] args) {
        merge(LeetCodeInputHelpers.stringToIntArray("[4,5,6,0,0,0]"), 3, LeetCodeInputHelpers.stringToIntArray("[1,2,3]"), 3);
    }
}
