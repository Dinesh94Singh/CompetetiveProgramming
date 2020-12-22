package com.company.codingscales.leetcode.concepts.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ShortestPathInAGridWithObstaclesElimination {
    static class Node {
        int r;
        int c;
        int limit;

        Node(int r, int c, int limit) {
            this.r = r;
            this.c = c;
            this.limit = limit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return new org.apache.commons.lang3.builder.EqualsBuilder()
                    .append(r, node.r)
                    .append(c, node.c)
                    .append(limit, node.limit)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                    .append(r)
                    .append(c)
                    .append(limit)
                    .toHashCode();
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int R = grid.length;
        int C = grid[0].length;

        int[][] visited = new int[R][C];
        for(int i = 0; i < R; i++)
            Arrays.fill(visited[i], -1);
        ArrayDeque<Node> dq = new ArrayDeque<>();

        dq.offerLast(new Node(0, 0, k));
        int res = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();

            for(int i = 0; i < size; i++) {
                Node n = dq.pollFirst();
                int x = n.r;
                int y = n.c;
                int K = n.limit;

                if (K == -1)
                    continue;
                if (x == R - 1 && y == C - 1)
                    return res;

                for (int[] direction : directions) {
                    int r = x + direction[0];
                    int c = y + direction[1];
                    if (0 <= r && r < R && 0 <= c && c < C) {
                        int limit = grid[r][c] == 0 ? K : K - 1;
                        if (K > visited[r][c]) {
                            visited[r][c] = limit;
                            dq.offerLast(new Node(r, c, limit));
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
