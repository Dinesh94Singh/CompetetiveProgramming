package com.company.codingscales.leetcode.concepts.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch2 {
    class Node {
        char ch;
        HashMap<Character, Node> children;
        String word = null;

        Node(char ch) {
            this.ch = ch;
            this.children = new HashMap<>();
        }
    }

    Node root = new Node('#');
    int R, C;
    char[][] board;
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // create trie with words

        for(String e : words) {
            addWord(e);
        }

        this.board = board;

        R = board.length;
        C = R > 0 ? board[0].length : 0;

        Node n = root;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                char ch = board[i][j];
                if (n.children.containsKey(ch)) {
                    dfs(i, j, n);
                }
            }
        }

        return res;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private void dfs(int i, int j, Node parent) {
        char ch = board[i][j];
        Node curr = parent.children.get(ch);

        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null; // so that, u dont add it back
        }


        board[i][j] = '.';
        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || x >= R || y < 0 || y >= C)
                continue;
            if (curr.children.containsKey(board[x][y]))
                dfs(x, y, curr);
        }
        board[i][j] = ch;

        if (curr.children.isEmpty())
            parent.children.remove(curr);
    }

    private void addWord(String each) {
        Node n = root;

        for (int i = 0; i < each.length(); i++) {
            char ch = each.charAt(i);
            if (!n.children.containsKey(ch))
                n.children.put(ch, new Node(ch));
            n = n.children.get(ch);
        }
        n.word = each;
    }
}
