package com.company.codingscales.leetcode.concepts.arrays;

import java.util.*;

public class DiagonalTraverse {
    /**
     * Solution with HashMap
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int R = matrix.length;
        int C = R > 0 ? matrix[0].length : 0;
        int[] res = new int[R * C];

        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int key = i + j;
                hm.putIfAbsent(key, new ArrayList<>());
                hm.get(key).add(matrix[i][j]);
            }
        }

        int d = 0;
        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            if (entry.getKey() % 2 == 0) {
                Collections.reverse(entry.getValue()); // inplace
                for(int each : entry.getValue()){
                    res[d++] = each;
                }
            } else {
                for(int each : entry.getValue()) {
                    res[d++] = each;
                }
            }
        }

        return res;
    }
}
