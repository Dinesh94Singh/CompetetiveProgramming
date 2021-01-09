package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

/**
 * Amazon interview question - 2019 interview for Ads team
 */
public class DistinctSubsequences {
    /**
         dfs(String a, String b, int i, int j) {
             if (j == b.length() && i == a.length())
                 return 1;
             if (i == a.length() || j == b.length())
                 return 0;

             int res = dfs(a, b, i + 1, j); // skip
             if (a.charAt(i) == b.charAt(j))
                 res += dfs(a,b,i+1,j+1); // consider

             return res;
         }
     */
    public int numDistinct(String a, String b) {
        // count the number of ways
        int n1 = a.length();
        int n2 = b.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        int cnt = 0;

        for(int i = 0; i < a.length(); i++) { // when you reach end, there should be valid
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
