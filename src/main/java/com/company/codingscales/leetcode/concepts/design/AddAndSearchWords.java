package com.company.codingscales.leetcode.concepts.design;

import java.util.HashMap;

public class AddAndSearchWords {
    static class TrieNode {
        Character ch;
        boolean isWord;
        String word;
        HashMap<Character, TrieNode> children;

        TrieNode() {}
        TrieNode(char ch) {
            this.ch = ch;
            this.children = new HashMap<>();
        }
    }

    TrieNode trie;

    public AddAndSearchWords() {
        trie = new TrieNode('#');
    }

    public void addWord(String word) {
        TrieNode curr = trie;
        int i = 0;
        while (i < word.length()) {
            char ch = word.charAt(i);
            if (curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            } else {
                curr.children.put(ch, new TrieNode(ch));
                curr = curr.children.get(ch);
            }
            i++;
        }

        curr.isWord = true;
        curr.word = word;
    }

    private boolean dfs(String rw, TrieNode curr) {
        if (rw.isEmpty())
            return curr.isWord;

        char ch = rw.charAt(0);
        if (ch == '.') {
            boolean res = false;
            for(TrieNode nxt : curr.children.values()) {
                res |= dfs(rw.substring(1), nxt);
            }
            return res;
        } else if (curr.children.containsKey(ch)) {
            return dfs(rw.substring(1), curr.children.get(ch));
        } else {
            return false;
        }
    }
    public boolean search(String word) {
        return dfs(word, trie);
    }

    public static void main(String[] args) {
        AddAndSearchWords sol = new AddAndSearchWords();
//        sol.addWord("bad");
//        sol.addWord("dad");
//        sol.addWord("mad");
//        System.out.println(sol.search("pad")); // false
//        System.out.println(sol.search("bad")); // true
//        System.out.println(sol.search(".ad")); // true
//        System.out.println(sol.search("b..")); // true
        AddAndSearchWords yasol = new AddAndSearchWords();
        yasol.addWord("a");
        yasol.addWord("a");
        System.out.println(yasol.search("."));
        System.out.println(yasol.search("a"));
        System.out.println(yasol.search("aa"));
        System.out.println(yasol.search("a"));
        System.out.println(yasol.search(".a"));
        System.out.println(yasol.search("a."));
    }
}
