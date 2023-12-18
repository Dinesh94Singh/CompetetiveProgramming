package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.*;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        // I can delete 2 elements with equal values
        // I can delete 3 elements with equal values

        // Minimum no: of operations required
        // Need to make the Nums empty

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        System.out.println(map);

        int count = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int t = entry.getValue();

            if (t == 1) {
                return -1;
            }

            count += Math.ceil((double) t / 3);
        }

        return count;
    }
}
