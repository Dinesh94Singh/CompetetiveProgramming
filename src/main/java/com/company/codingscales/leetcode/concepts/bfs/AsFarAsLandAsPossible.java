package com.company.codingscales.leetcode.concepts.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

import javafx.util.Pair;

public class AsFarAsLandAsPossible {
    public int maxDistance(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        ArrayDeque<Pair<Integer, Integer>> dq = new ArrayDeque<>();

        int[][] distance = new int[R][C];

        for (int[] each : distance) {
            Arrays.fill(each, Integer.MAX_VALUE);
        }

        HashSet<Pair<Integer, Integer>> seen = new HashSet<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    distance[i][j] = 0;
                    dq.offerLast(new Pair<>(i, j));
                    seen.add(new Pair<>(i, j));
                }
            }
        }

        System.out.println(dq);
        for (int i = 0; i < R; i++)
            System.out.println(Arrays.toString(distance[i]));

        System.out.println();

        if (dq.isEmpty()) // no land found
            return -1;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        int level = 0;

        System.out.println("Starting BFS !! ");
        System.out.println();

        while (!dq.isEmpty()) {
            int n = dq.size();
            System.out.println(dq);
            System.out.println();
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> p = dq.pollFirst();

                for (int[] each : dirs) {
                    int x = p.getKey() + each[0];
                    int y = p.getValue() + each[1];

                    Pair<Integer, Integer> pair = new Pair<>(x, y);

                    if (0 <= x && x < R && 0 <= y && y < C && !seen.contains(pair)) {
                        seen.add(pair);
                        dq.offerLast(pair);
                        distance[x][y] = Math.min(distance[x][y], level + 1);
                    }
                }
            }

            level++;
        }

        int res = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res = Math.max(res, distance[i][j]);
            }
        }

        for (int i = 0; i < R; i++)
            System.out.println(Arrays.toString(distance[i]));

        System.out.println();

        return res == 0 ? -1 : res;
    }

    public static void main(String[] args) {
        AsFarAsLandAsPossible sol = new AsFarAsLandAsPossible();
        int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        int[][] grid2 = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(sol.maxDistance(grid));
        System.out.println("\n\n Running second test !! \n");
        System.out.println(sol.maxDistance(grid2));
    }
}
