package com.company.codingscales.leetcode.concepts.dynamicProgramming.knight;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class MinimumKnightMoves {
    public int minKnightMovesTLEs(int x, int y) { // Simple BFS with level order traversal TLE's
        // always start at (0, 0)
        // when you meet (x, y) => return this res

        // bfs - Level order traversal ?? // visited set, to prevent cycles - ans will exist
        // boundaries go from -inf till +inf

        int[][] dirs = {
                {-1, -2},
                {-2, -1},
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2}
        };

        ArrayDeque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        dq.offer(new Pair<>(0, 0));
        HashSet<Pair<Integer, Integer>> hs = new HashSet<>();
        hs.add(new Pair<>(0, 0));
        int dist = 0;
        while (!dq.isEmpty()) {
            int n = dq.size();
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> curr = dq.pollFirst();
                if (curr.getKey() == x && curr.getValue() == y) { return dist; }

                for (int[] dir : dirs) {
                    Pair<Integer, Integer> p = new Pair<>(curr.getKey() + dir[0], curr.getValue() + dir[1]);

                    if (hs.contains(p)) {
                        continue;
                    }

                    hs.add(p);
                    dq.offerLast(p);
                }
            }
            dist++;
        }

        return -1; // shoudl never occur
    }

    public int minimumKnightMovesOptimized(int x, int y) {
        // the move is symmetric in all directions, so, instead of going in all directions, just stick to 1 quadrant
        // for co-ordinates like (1, 1), (2, 0), (0, 2), you have to visit the other quadrants, but shouldn't completely cross them
        // One way to ensure this is to allow some part of other quadrants.
        // other way to do is, if (abs(x), abs(y)) >= (4, 4) then stick to q1 quad, else check all the quads

        x = Math.abs(x);
        y = Math.abs(y);

        Set<String> visited = new HashSet<>();
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        dq.offerLast(new int[]{0, 0});
        int dist = 0;
        int[][] dirs = {
                {-1, -2},
                {-2, -1},
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2}
        };
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.pollFirst();
                if (curr[0] == x && curr[1] == y) {
                    return dist;
                }

                for (int[] d : dirs) {
                    int r = d[0] + curr[0];
                    int c = d[1] + curr[1];
                    // allowing some part of other co-ords instead of fixing to (0, 0)
                    if (visited.add(r + "," + c) && r >= -1 && c >= -1) {
                        dq.offerLast(new int[]{r, c});
                    }
                }
            }
            dist++;
        }

        return -1; // this shouldn't happen, since guaranteed to have an solution
    }
}
