package com.company.codingscales.leetcode.concepts.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinimumMovesToMoveABoxToTheirTargetLocation {
    static class Tuple implements Comparable<Tuple> { // when using PQ, always use Comparable

        int cost;
        int movesSoFar;
        int[] personPos;
        int[] boxPos;

        Tuple(int cost, int movesSoFar, int[] personPos, int[] boxPos) {
            this.cost = cost;
            this.movesSoFar = movesSoFar;
            this.personPos = personPos;
            this.boxPos = boxPos;
        }

        @Override
        public int compareTo(final Tuple other) {
            return this.cost - other.cost;
        }
    }

    int findDistance(int[] boxPos, int[] targetPos) {
        return Math.abs(targetPos[0] - boxPos[0]) + Math.abs(targetPos[1] - boxPos[1]);
    }

    char[][] grid;
    boolean isOutOfBounds(int[] pos, int R, int C) {
        int r = pos[0];
        int c = pos[1];

        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '#')
            return true;
        return false;
    }

    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    int minPushBox(char[][] grid) {
        this.grid = grid;
        int R = grid.length;
        int C = R > 0 ? grid[0].length : 0;

        int[] person = new int[]{};
        int[] box = new int[]{};
        int[] target = new int[]{};

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (grid[i][j] == 'T')
                    target = new int[]{i, j};
                if (grid[i][j] == 'B')
                    box = new int[]{i, j};
                if (grid[i][j] == 'S')
                    person = new int[]{i, j};
            }
        }

        PriorityQueue<Tuple> minQ = new PriorityQueue<>();
        minQ.offer(new Tuple(findDistance(box, target), 0, person, box));
        HashSet<String> visited = new HashSet<>();

        while (!minQ.isEmpty()) {
            Tuple t = minQ.poll();
            if (Arrays.equals(target, t.boxPos)) {
                return t.movesSoFar;
            }

            String key = t.personPos[0] + "#" + t.personPos[1] + "#" + t.boxPos[0] + "#" + t.boxPos[1];

            if (visited.contains(key)) // box was here previously, so don't be in cycle
                continue;

            visited.add(key);

            for(int[] dir : directions) {
                int[] updatedPersonPos = new int[]{dir[0] + t.personPos[0], dir[1] + t.personPos[1]};

                if (isOutOfBounds(updatedPersonPos, R, C))
                    continue;

                if (Arrays.equals(t.boxPos, updatedPersonPos)) {
                    // person reached the box
                    int[] updatedBoxPos = new int[]{dir[0] + t.boxPos[0], dir[1] + t.boxPos[1]};

                    if (isOutOfBounds(updatedBoxPos, R, C))
                        continue;

                    minQ.offer(new Tuple(findDistance(updatedBoxPos, target) + t.movesSoFar + 1, t.movesSoFar + 1, updatedPersonPos, updatedBoxPos));
                } else { // box doesn't move
                    // if there is not path for person to box, then pq will eventually be empty, after visiting all pos
                    minQ.offer(new Tuple(findDistance(updatedPersonPos, target) + t.movesSoFar, t.movesSoFar, updatedPersonPos, t.boxPos));
                }
            }
        }

        return -1;
    }

}
