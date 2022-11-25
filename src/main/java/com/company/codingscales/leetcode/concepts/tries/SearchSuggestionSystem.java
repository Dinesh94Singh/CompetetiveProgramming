package com.company.codingscales.leetcode.concepts.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class SearchSuggestionSystem {
    class TrieNode {
        Character key;
        TreeSet<String> words;
        HashMap<Character, TrieNode> children;


        public TrieNode() {
            this.key = ' ';
            this.words = new TreeSet<>();
            this.children = new HashMap<>();
        }
    }


    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> res = new ArrayList<>();
        for (String p : products) {
            TrieNode root = trie.root;

            for (char ch : p.toCharArray()) {
                if (!root.children.containsKey(ch)) {
                    TrieNode t = new TrieNode();
                    t.key = ch;
                    t.words.add(p);

                    root.children.put(ch, t);
                    root = t;
                } else {
                    root = root.children.get(ch);
                    root.words.add(p);
                }
            }
        }

        TrieNode root = trie.root;

        for (char ch : searchWord.toCharArray()) {
            if (!root.children.containsKey(ch))
                break;

            root = root.children.get(ch);
            List<String> temp = new ArrayList<>();
            int k = 0;
            for (String e : root.words) {
                temp.add(e);
                k++;

                if (k == 3)
                    break;
            }

            res.add(new ArrayList<>(temp));
        }

        return res;
    }

    public static void main(String[] args) {
        SearchSuggestionSystem s = new SearchSuggestionSystem();
        s.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }
}
