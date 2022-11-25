package com.company.codingscales.leetcode.concepts.arrays;

import java.util.HashMap;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i > 0 && j > 0 && A[i][j] != A[i-1][j-1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isToeplitzMatrixUsingMap(int[][] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if (!map.containsKey(i - j)) {
                    map.put(i - j, A[i][j]);
                } else if (map.get(i - j) != A[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
