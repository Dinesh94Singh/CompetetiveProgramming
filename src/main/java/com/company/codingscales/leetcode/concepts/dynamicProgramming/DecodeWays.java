package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class DecodeWays {
    static int[] dp;
    private static int recHelper(int index, String s) {
        if (index == s.length())
            return 1;
        if (index > s.length())
            return 0;

        if (dp[index] != 0)
            return dp[index];

        char ch = s.charAt(index);
        if (ch == '0')
            return 0;

        if (index < s.length() - 1) {
            int twoDigitNumber = Character.getNumericValue(ch) * 10 + Character.getNumericValue(s.charAt(index + 1));

            if (twoDigitNumber == 10) {
                dp[index] = recHelper(index + 2, s); return dp[index];
            } else if (twoDigitNumber >= 27) {
                dp[index] = recHelper(index + 1, s); return dp[index];
            }
        }

        dp[index] = recHelper(index + 1, s) + recHelper(index + 2, s);
        return dp[index];
    }


    public static int numDecodings(String s) {
        dp = new int[s.length()];
        return recHelper(0, s);
    }

    public static int numDecodingsDP(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }

    public static void main(final String[] args) {
        System.out.println(numDecodings("226")); // It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    }

}
