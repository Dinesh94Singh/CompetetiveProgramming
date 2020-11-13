package com.company.codingscales.interviews.goldmansachs;

import java.util.HashMap;
import java.util.Map;

// TODO: Do again => Placeholder to understand the LC Solution better

/**
 * leftis a hashmap, left[i] counts the number of i that I haven't placed yet.
 * endis a hashmap, end[i] counts the number of consecutive subsequences that ends at number i
 * Then I tried to split the nums one by one.
 * If I could neither add a number to the end of a existing consecutive subsequence nor find two following number in the left, I returned False
 */
public class SplitArrayIntoConsequitiveSequences {
    public boolean isPossible(final int[] nums) {
        final Map<Integer, Integer> left = new HashMap<>();
        final Map<Integer, Integer> end = new HashMap<>();

        for (final int num : nums) {
            left.put(num, left.getOrDefault(num, 0) + 1);
        }

        for (final int num : nums) {
            if (left.get(num) <= 0) { // all placed
                continue;
            }

            left.put(num, left.get(num) - 1); // place it now

            if (end.containsKey(num - 1) && end.get(num - 1) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
            else if (left.containsKey(num + 1) && left.containsKey(num + 2)
                    && left.get(num + 1) > 0 && left.get(num + 2) > 0) {
                left.put(num + 1, left.get(num + 1) - 1);
                left.put(num + 2, left.get(num + 2) - 1);
                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
            }
            else {
                return false;
            }
        }

        return true;
    }
}
