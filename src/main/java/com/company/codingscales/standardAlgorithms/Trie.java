package com.company.codingscales.standardAlgorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Trie {
    static class TrieNode {
        Character ch;
        Map<Character, TrieNode> children;
        boolean isEnd;
        String word;

        TrieNode(final Character val) {
            this.ch = val;
            this.children = new HashMap<>();
            this.isEnd = false;
            this.word = null;
        }
    }

    TrieNode root;

    Trie() {
        root = new TrieNode(null);
    }

    private boolean dfs(final String word, TrieNode node) {
        if (word.isEmpty() && node.isEnd) {
            return true;
        }

        if (node.children.containsKey(word.charAt(0))) {
            node = node.children.get(word.charAt(0));
        } else {
            return false;
        }

        return dfs(word.substring(1), node);
    }

    private void buildTrie(final ArrayList<String> words) {
        TrieNode node;
        for (final String word : words) {
            node = this.root;
            for (final char ch : word.toCharArray()) {
                node = node.children.getOrDefault(ch, new TrieNode(ch));
            }
            node.isEnd = true;
            node.word = word;
        }
    }
}
