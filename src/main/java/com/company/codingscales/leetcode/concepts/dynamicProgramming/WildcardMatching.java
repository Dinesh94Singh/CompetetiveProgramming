package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class WildcardMatching {
    static Boolean[][] dp;

    private static boolean recHelper(final int sIndex, final int pIndex, final String s, final String p) {
        if (pIndex == p.length())
            return sIndex == s.length();

        if (sIndex == s.length())
            return p.charAt(pIndex) == '*' && recHelper(sIndex, pIndex + 1, s, p);

        if (dp[sIndex][pIndex] != null)
            return dp[sIndex][pIndex];

        if (p.charAt(pIndex) == '*') {
            boolean res = false;
            res |= recHelper(sIndex + 1, pIndex, s, p);
            res |= recHelper(sIndex, pIndex + 1, s, p);
            dp[sIndex][pIndex] = res;
        } else if (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex)) {
            dp[sIndex][pIndex] = recHelper(sIndex + 1, pIndex + 1, s, p);
        } else {
            dp[sIndex][pIndex] = false;
        }

        return dp[sIndex][pIndex];
    }

    public static boolean isMatch(final String s, final String p) {
        dp = new Boolean[s.length()][p.length()];
        return recHelper(0, 0, s, p);

    }

    public static void main(String[] args) {
        System.out.println(isMatch("cb", "?a"));
    }
}
