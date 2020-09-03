package com.company.codingscales.interviews.microsoft;

import java.util.HashMap;
import java.util.Map;

public class NumberWithEqualDigitSum {
    private static int solve(final int[] arr) {
        final HashMap<Integer, Integer> hm = new HashMap<>();
        for(final int a: arr) {
            int total = 0;
            for(final char ch : String.valueOf(a).toCharArray()) {
                total += ((int) ch - 48);
            }
            if (!hm.containsKey(total))
                hm.put(total, 0);
            hm.put(total, hm.get(total) + a);
        }

        int maximumSum = Integer.MIN_VALUE;
        for(final Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            maximumSum = Math.max(entry.getValue(), maximumSum);
        }

        return maximumSum != Integer.MIN_VALUE ? maximumSum : -1;
    }

    /**
     * TC - O(2n) SC - O(2n)
     */
    public static void main(final String[] args) {
        final int[] arr = new int[] {51, 71, 17, 42};
        System.out.println(solve(arr));
    }
}
