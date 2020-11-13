package com.company.codingscales.interviews.goldmansachs;

import java.util.Map;
import java.util.TreeMap;

public class DivideArrayInSetsOfKConsequitiveNumbers {
    /**
     *
     * Same Solution for - https://leetcode.com/problems/hand-of-straights/
     * Count number of different cards to a map c
     * Loop from the smallest card number.
     * Everytime we meet a new card i, we cut off i - i + k - 1 from the counter.
     *
     * O(NLogM)
     */
    public boolean isPossibleDivide(int[] A, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : A) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = W - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it))
                        return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }
}
