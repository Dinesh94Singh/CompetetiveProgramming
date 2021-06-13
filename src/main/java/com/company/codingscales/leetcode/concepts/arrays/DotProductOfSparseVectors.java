package com.company.codingscales.leetcode.concepts.arrays;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfSparseVectors {
    static class SparseVector {
        HashMap<Integer, Integer> sparse;
        SparseVector(int[] nums) {
            sparse = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    sparse.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int res = 0;
            for(Map.Entry<Integer, Integer> entry : this.sparse.entrySet()) {
                int idx = entry.getKey();
                if (vec.sparse.containsKey(idx)) {
                    res += vec.sparse.get(idx) * entry.getValue();
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 1};
        int[] B = {0, 7, 7};

        SparseVector svA = new SparseVector(A);
        SparseVector svB = new SparseVector(B);

        System.out.println(svA.dotProduct(svB));
    }
}
