package com.company.codingscales.leetcode.concepts.binarySearch;

public class MissingElementInSortedArray {
        private int getElementsMissingSoFar(int idx, int[] A) {
            return A[idx] - A[0] - idx;
        }

        public int missingElement(int[] A, int k) {
            if (A[A.length - 1] - A[0] - A.length + 1 < k) {
                // element missing is beyond the array right boundary

                // return A[A.length - 1] + k - A[A.length - 1] + A[0] - A.length + 1;
                // return k - A.length + 1 + A[0];

                return A[A.length - 1] + k - getElementsMissingSoFar(A.length - 1, A);
            }

            if (k == 0)
                return -1;

            int lo = 0, hi = A.length - 1;

            while (lo <= hi) {
                int mid = (lo + (hi - lo) / 2);

                int missingSoFar = A[mid] - A[0] - mid;

                if (missingSoFar < k) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            System.out.println("hi" + hi);
            int missingUntilHi = A[hi] - A[0] - hi;
            // return A[hi] + k - missingUntilHi => A[hi] + k - A[hi] + A[0] + hi;
            return k + hi + A[0];
        }
}
