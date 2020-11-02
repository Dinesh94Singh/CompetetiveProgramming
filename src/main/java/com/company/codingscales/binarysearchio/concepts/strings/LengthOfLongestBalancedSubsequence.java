package com.company.codingscales.binarysearchio.concepts.strings;

// give string ())(() => result is 4 because of subsequence => ()() and we skip )(
public class LengthOfLongestBalancedSubsequence {
    int dfs(String s, int index, int open, int close) {
        if (s.length() == index) {
            return Math.min(open, close) * 2;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            return dfs(s, index + 1, open + 1, close);
        } else if (close < open) {
            return dfs(s, index + 1, open, close + 1);
        } else {
            return dfs(s, index + 1, open, close);
        }
    }

    public int solve(String s) {
        return dfs(s, 0, 0, 0);
    }
}
