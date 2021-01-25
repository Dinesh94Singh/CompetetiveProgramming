package com.company.codingscales.leetcode.concepts.backtracking;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        return countVowelStringUtil(n, 1);
    }

    int countVowelStringUtil(int n, int vowels) {
        if (n == 0)
            return 1;
        int result = 0;
        for (int i = vowels; i <= 5; i++) {
            result += countVowelStringUtil(n - 1, i);
        }
        return result;
    }
}
