package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrisionCells {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> hm = new HashMap<>();
        final Function<int[], String> convertToString = (c) -> Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(","));
        final Function<int[], int[]> nextDay = (c) -> {
            final int[] res = new int[c.length];
            Arrays.fill(res, 0);
            for (int i = 1; i < 7; i++) {
                res[i] = (c[i - 1] == c[i + 1] ? 1 : 0);
            }
            return res;
        };

        while (N > 0) {
            final String s = convertToString.apply(cells);

            if (hm.containsKey(s)) {
                final int index = hm.get(s);
                final int gap = N - index;
                N = N % gap;
            } else {
                hm.put(s, N);
            }

            if (N >= 1) {
                cells = nextDay.apply(cells);
                N--;
            }
        }

        return cells;
    }
}
