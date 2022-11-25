package com.company.codingscales.leetcode.concepts.arrays;

public class FindKthMissingElement {

    /**

     A - [2,3,4,7,11]

     [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]


     mid = (0 + 5) / 2 = 2

                              v
     missing so far at [2, 3, 4, 7, 11] => 4 - 2 - 1 => 1 missing elment => (k == 1)

     so far there are 1 missing elements. Now need to find out pos where i - 1 has k - 1 missing elements and i + 1 has k missing elements.

     so, keep exploring left.

     **/



    public int findKthPositive(int[] A, int k) {
        int lo = 0, hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);

            int missingSoFar = A[mid] - mid - 1;

            if (missingSoFar < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo + k;
    }

}
