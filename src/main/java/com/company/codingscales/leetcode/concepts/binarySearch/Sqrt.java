package com.company.codingscales.leetcode.concepts.binarySearch;

/**
 * We start at left=2, right=x/2. Every time, we find pivot=(left+right)//2.
 * If pivot*pivot < x or pivot<sqrt(x), we move "left" pointer to pivot+1.
 * If pivot*pivot > x or pivot>sqrt(x), we move "right" pointer to pivot-1.
 * if pivot==sqrt(x), we exit early (e.g. 81).
 * Thus, "left" converges towards sqrt(x) from below. "right" converges to sqrt(x) from above.
 * If "left" overshoots sqrt(x), the only pointer moved will be "right". Moving "right" to pivot-1 will result in the "right" pointer eventually undershooting sqrt. Hence, the convergence will stop with right<left.
 * Since, the problem asks for a floor() or undershoot, we return "right".
 * You can develop this into what happens if "right" undershoots sqrt before "left" overshoots it: "left" will just keep going pivot+1 until it overshoots sqrt and the "right" pointer.
 */
public class Sqrt {
    public int sqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 2;
        int right = x / 2;

        while (left <= right) {
            final int pivot = left + (right - left) / 2;

            final long num = (long) pivot * pivot;

            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return right; // y right, y not left =>  right * right <= x < left * left.
    }
}
