package com.company.codingscales.leetcode.concepts.arrays;

public class findMedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        if (M > N) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int combined = M + N;
        int half = (combined + 1) / 2;
        int lo = 0;
        int hi = nums1.length;

        /**
         * Always get the max of leftHalfs and min of rightHalfs
         */
        while (lo <= hi) {
            int partX = (lo + (hi - lo) / 2);
            int partY = half - partX; // most important part

            // why half - partX => if we have total 10 elements then, this can be divided into 11 partitions,
            // empty (left), 10 right
            // 1 (left), 9 right ...... 10 (left) | empty(right)

            // if we divide the partition at i = 2 then left will have 2 else and right will have 8 els. We pick half of both first half and second half (binary search)
            // (11 / 2) - i => 5 - 2 => 3 is where cut the second array -> 8 / 2 => 4.

            // TELL THIS TO INTERVIEWER.
            // right partition = (total length of right partition) / 2 => total length of both combined - no of element in first partition / 2

            int leftX = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int rightX  = partX == M ? Integer.MAX_VALUE : nums1[partX];

            int leftY = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int rightY = partY == N ? Integer.MAX_VALUE : nums2[partY];

            if (leftX <= rightY && leftY <= rightX) {
                if ((M + N) % 2 == 0)
                    return (double) ((Math.max(leftX, leftY)) + Math.min(rightX, rightY)) / 2.0;
                else
                    return Math.max(leftX, leftY);
            } else if (leftX > rightY) {
                // move towards left
                hi = partX - 1;
            } else {
                lo = partX + 1;
            }
        }

        return 0;
    }
}
