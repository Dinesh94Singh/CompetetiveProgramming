package com.company.codingscales.leetcode.concepts.dynamicProgramming;

// TODO: Try Again. Try to come up something like this, yourself. Solution referred from https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments java sol in comment section.
public class PalindromeRemoval {
    int[][] dp;

    /**
     * Idea: There are 3 types of palindromes.
     * 1. Character by itself (can't go along with any other characters) -> we need to find the min steps required to remove the rest of the string (base condition)
     * 2. Characters which are side to each other (eg: aa, cc, 11, 22) -> we need to find the min steps required to remove the rest of the string. (Special condition to safe guard odd length palindromes)
     * 3. Characters which have few characters in-between => (a bc a) -> we need to find the min steps required to remove bc (base condition)
     */
    int dfs(final int lo, final int hi, final int[] arr) {
        if (lo > hi)
            return 0;
        if (lo == hi)
            return 1;

        if (dp[lo][hi] != 0)
            return dp[lo][hi];

        int min = dfs(lo + 1, hi, arr) + 1; // skip the one at this index
        if (arr[lo] == arr[lo + 1]) // skip the palindrome with length 2
            min = Math.min(min, dfs(lo + 2, hi, arr) + 1); // + 1 since we removed [lo, lo + 1] sub-array from the arr

        for(int k = lo + 2; k <= hi; k++) { // + 2 since, [lo, (something), k], where k, begins from k+2 and expands the sliding window
            if (arr[lo] == arr[k]) {
                /**
                 * hoping to remove in-between, also covers removing arr[i] == arr[j] (like LPS problem), the result, should be the
                 * min steps required to remove the in-between values
                 */
                min = Math.min(min, dfs(lo + 1, k -1, arr) + dfs(k + 1, hi, arr));
            }
        }

        dp[lo][hi] = min;
        return dp[lo][hi];
    }

    public int minimumMoves(final int[] arr) {
        final int n = arr.length;
        dp = new int[n][n];
        return dfs(0, n - 1, arr);
    }
}
