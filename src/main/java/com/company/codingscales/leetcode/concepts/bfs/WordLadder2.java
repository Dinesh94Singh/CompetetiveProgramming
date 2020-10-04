package com.company.codingscales.leetcode.concepts.bfs;

import java.util.*;

public class WordLadder2 {
    List<List<String>> res;
    Integer minDist = Integer.MAX_VALUE;

    // TLE's
    private void dfs(final String word, final String endWord, final int distance, final HashMap<String, List<String>> dict, final List<String> wordList) {
        if (distance > minDist)
            return;
        if (endWord.equals(word)) {
            if (distance > minDist)
                return;
            if (distance < minDist) {
                minDist = distance;
                res.clear();
            }
            res.add(new ArrayList<>(wordList));
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            final String iw = word.substring(0, i) + "#" + word.substring(i + 1);
            for (final String each : dict.getOrDefault(iw, new ArrayList<>())) {
                if (!wordList.contains(each)) { // prevents cycle
                    wordList.add(each);
                    dfs(each, endWord, distance + 1, dict, wordList);
                    wordList.remove(wordList.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(final String beginWord, final String endWord, final List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty())
            return new ArrayList<>();
        if (beginWord.equals(endWord))
            return new ArrayList<>();

        final HashMap<String, List<String>> dict = new HashMap<>();
        res = new ArrayList<>();
        for (final String each : wordList) {
            for(int i = 0; i < each.length(); i++) {
                final String iw = each.substring(0, i) + "#" + each.substring(i + 1);
                dict.putIfAbsent(iw, new ArrayList<>());
                dict.get(iw).add(each);
            }
        }

        final List<String> wl = new ArrayList<>();
        wl.add(beginWord);

        dfs(beginWord, endWord, 0, dict, wl);
        return res;
    }

    public static void main(String[] args) {
        final WordLadder2 ladder = new WordLadder2();
        final ArrayList<String> words = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        ladder.findLadders("hit", "cog", words);
    }
}
