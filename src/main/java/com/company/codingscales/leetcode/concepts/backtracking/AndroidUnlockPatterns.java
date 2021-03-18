package com.company.codingscales.leetcode.concepts.backtracking;

public class AndroidUnlockPatterns {
    private static final int[][] skip = new int[10][10];

    static int dfs(boolean[] visited, int cur, int remaining) {
        if (remaining < 0)
            return 0;
        if (remaining == 0)
            return 1;

        visited[cur] = true;
        int ans = 0;
        for(int i = 1; i <= 9; i++) {
            // 2 numbers adjacent or pass-through a skip  number
            // skip[cur][i] = 0 means, they are adjacent to each other
            // if its not zero, they pass through something, so check if its visited.

            if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
                ans += dfs(visited, i, remaining - 1);
            }
        }
        visited[cur] = false;
        return ans;
    }

    public static int numberOfPatterns(int m, int n) {
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        // at-least m keys and at most n keys
        boolean[] visited = new boolean[10]; // 10digits
        int ans = 0;
        for (int i = m; i <= n; i++) {
            ans += dfs(visited, 1, i - 1) * 4; // if you don't remember this, just do dfs(1->9)
            ans += dfs(visited, 2, i - 1) * 4;
            ans += dfs(visited, 5, i - 1);
        }

        return ans;
    }
}
