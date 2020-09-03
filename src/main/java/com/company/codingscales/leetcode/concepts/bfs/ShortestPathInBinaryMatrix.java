package com.company.codingscales.leetcode.concepts.bfs;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayDeque;

public class ShortestPathInBinaryMatrix {
    private static int dir[][] = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    private static int R;
    private static int C;

    private int performBfs(ArrayDeque<int[]> deque, int level, boolean[][] visited, int[][] grid) {
        while(!deque.isEmpty()) {
            int n = deque.size();
            while (n > 0) {
                int[] pos = deque.removeFirst();
                if (pos[0] == R && pos[1] == C) { return level; }

                for(int[] eachDir : dir) {
                    int x = pos[0] + eachDir[0];
                    int y = pos[1] + eachDir[1];

                    if (0 <= x && x <= R && 0 <= y && y <= C && grid[x][y] != 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        int[] p = new int[]{x, y};
                        deque.addLast(p);
                    }
                }
                n--;
            }
            level++;
        }

        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length - 1;
        C = R > 0 ? grid[0].length - 1: 0;

        if (grid[0][0] == 1 || grid[R][C] == 1) { return -1; }

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[R + 1][C + 1];
        deque.add(new int[]{0, 0});

        return performBfs(deque, 1, visited, grid);
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix sol = new ShortestPathInBinaryMatrix();
        System.out.println(sol.shortestPathBinaryMatrix(LeetCodeInputHelpers.stringToInt2dArray("[[0,1],[1,0]]")));
        System.out.println(sol.shortestPathBinaryMatrix(LeetCodeInputHelpers.stringToInt2dArray("[[1,0,0],[1,1,0],[1,1,0]]")));
        System.out.println(sol.shortestPathBinaryMatrix(LeetCodeInputHelpers.stringToInt2dArray("[[0,0,0,0,1],[1,0,0,0,0],[0,1,0,1,0],[0,0,0,1,1],[0,0,0,1,0]]")));
    }
}
