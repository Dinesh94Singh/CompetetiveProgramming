package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak2 {
    // Instead of using HashMap<String, List<String>> and add the iw to that list is cumbersome, and consumes too much memory.
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

    // Prefer these two solutions.
    static class WordBreakDFSWithMapOfLists {
        public List<String> wordBreak(String s, Set<String> wordDict) {
            return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
        }

        // DFS function returns an array including all substrings derived from s.
        List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
            if (map.containsKey(s))
                return map.get(s);

            LinkedList<String>res = new LinkedList<String>();
            if (s.isEmpty()) {
                res.add("");
                return res;
            }
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                    for (String sub : sublist)
                        res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
            map.put(s, res);
            return res;
        }
    }

    static class WordBreakDPSolution {
        private void updateCharSet(String s, HashSet<Character> charSet) {
            for (int i = 0; i < s.length(); ++i)
                charSet.add(s.charAt(i)); // max 26 ?
        }

        // prefer this a lot
        public List<String> wordBreak(String s, List<String> wordDict) {
//            unnecessary bull shit
//            HashSet<Character> stringCharSet = new HashSet<Character>();
//            updateCharSet(s, stringCharSet);
//
//            HashSet<Character> wordCharSet = new HashSet<>();
//            wordSet = new HashSet<>();
//            for (String word : wordDict) {
//                wordSet.add(word);
//                updateCharSet(word, wordCharSet);
//            }
//
//            // quick check on the sets of characters
//            if (!wordCharSet.containsAll(stringCharSet))
//                return new ArrayList();

            Set<String> wordSet = new HashSet<>(wordDict);
            ArrayList<ArrayList<String>> dp = new ArrayList<>(s.length() + 1);
            for (int i = 0; i < s.length() + 1; ++i)
                dp.add(new ArrayList<>());
            
            dp.get(0).add("");

            for (int endIndex = 1; endIndex < s.length() + 1; ++endIndex) {
                ArrayList<String> sublist = new ArrayList<String>();

                // fill up the values in the dp array.
                for (int startIndex = 0; startIndex < endIndex; ++startIndex) {
                    String word = s.substring(startIndex, endIndex);
                    if (wordSet.contains(word))
                        sublist.add(dp.get(startIndex).stream().map(String::valueOf).collect(Collectors.joining(" ")));
                }
                dp.set(endIndex, sublist);
            }

            return dp.get(s.length());
        }
    }

    public static void main(String[] args) {
        WordBreak2 wordBreak2 = new WordBreak2();
        System.out.println(wordBreak2.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
