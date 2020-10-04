package com.company.codingscales.leetcode.concepts.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;

public class SnakesAndLadders {
    private static int[] getIndices(final int index, final int N) {
        final int q = (index - 1) / N;
        final int r = (index - 1) % N;

        int row = N - 1 - q;
        int col = r;

        if (row % 2 == N % 2)
            return new int[]{row, N - 1 - col}; // reverse

        return new int[]{row, col};

    }

    public int snakesAndLadders(final int[][] board) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int N = board.length;
        dq.offerLast(1);

        final HashMap<Integer, Integer> distances = new HashMap<>();
        while (!dq.isEmpty()) {
            int pos = dq.pollFirst();
            if (pos == N * N)
                return distances.get(pos);
            for (int i = pos + 1; i < Math.min(pos + 6, N * N) + 1; i++) {
                final int[] newPos = getIndices(i, N);
                final int x = newPos[0];
                final int y = newPos[1];
                int ladder = i;
                if (board[x][y] != -1)
                    ladder = board[x][y];

                if (!distances.containsKey(ladder)) {
                    distances.put(ladder, distances.get(pos) + 1);
                    dq.offerLast(ladder);
                }
            }
        }

        return -1;
    }
}
