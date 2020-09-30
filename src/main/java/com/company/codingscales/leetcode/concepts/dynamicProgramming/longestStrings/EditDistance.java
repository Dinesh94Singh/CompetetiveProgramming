package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class EditDistance {
    private static int recHelper(final int idx1, final int idx2, final String word1, final String word2) {
        System.out.println(idx1 + " , " + idx2 + " , " + word1 + " , " + word2);
        if (idx1 >= word1.length() && idx2 >= word2.length()) {
            return 0;
        }

        if (idx1 >= word1.length() || idx2 >= word2.length()) {
            return word1.length() == idx1 ? word2.length() - idx2 : word1.length() - idx1;
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return recHelper(idx1 + 1, idx2 + 2, word1, word2);
        }

        final int add = recHelper(idx1 + 1, idx2, word1, word2) + 1;
        final int delete = recHelper(idx1, idx2 + 1, word1, word2) + 1;
        final int replace = recHelper(idx1 + 1, idx2 + 1, word1, word2) + 1;

        return Math.min(replace, Math.min(add, delete));
    }

    private static int minDistanceBottomUp(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;

        for(int i = 0; i <= word2.length(); i++)
            dp[0][i] = i;

        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }


    public static int minDistance(final String word1, final String word2) {
        return recHelper(0, 0, word1, word2);
    }

    public static void main(final String[] args) {
        System.out.println(minDistance("horse", "hor"));
    }
}
