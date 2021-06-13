package com.company.codingscales.leetcode.concepts.interactive;


public class FirstBadVersion {

    // isBadVersion is Interactive API
    static boolean isBadVersion(int x) {
        return false;
    }

    public int firstBadVersion(int n) {
        // binary search
        int lo = 0;
        int hi = n;

        while (lo < hi) {
            int mid = (lo + (hi - lo) / 2);

            boolean isBad = isBadVersion(mid);

            if (isBad) {
                // explore left
                hi = mid; // non-inclusive
            } else { // search right side
                lo = mid + 1;
            }
        }

        return lo;
    }
}
