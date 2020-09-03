package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak2 {
    private void recHelper(int index, String remainingStr, Set<String> words, List<String> al, List<String> res, boolean[] dp) {
        if (dp[index + remainingStr.length()]) {
            if (remainingStr.isEmpty()) {
                res.add(al.stream().collect(Collectors.joining(" ")));
                return;
            }

            for (int i = 0; i < remainingStr.length(); i++) {
                if (words.contains(remainingStr.substring(0, i + 1))) {
                    al.add(remainingStr.substring(0, i + 1));
                    recHelper(index + i + 1, remainingStr.substring(i + 1), words, al, res, dp);
                    al.remove(al.size() - 1);
                }
            }
        }
    }

    private void build_dp(String s, boolean[] dp, Set<String> words) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() + 1; j++) {
                String substring = s.substring(i, j);
                if (dp[i] && words.contains(substring)) {
                    dp[j] = true;
                }
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<String>(wordDict);
        List<String> res = new ArrayList<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        build_dp(s, dp, words);

        recHelper(0, s, words, new ArrayList<String>(), res, dp);
        return res;
    }

    public static void main(String[] args) {
        WordBreak2 wordBreak2 = new WordBreak2();
        System.out.println(wordBreak2.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
