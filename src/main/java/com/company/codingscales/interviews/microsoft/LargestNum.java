package com.company.codingscales.interviews.microsoft;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LargestNum {
    static int getLargestNum(final int[] array) {
        final Map<Integer, Integer> hm = new HashMap<>();
        for (final int i : array) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        System.out.println(hm);

        // Integer[] keys = Arrays.copyOf(hm.keySet().toArray(), hm.size(), Integer[].class);
        // skip anything bigger than 100,000
        int res = 0;

        for(final Integer key: hm.keySet()) {
           if (key.equals(hm.get(key))) {
               res = Math.max(res, key);
           }
        }
        return res;
    }

    public static void main(final String[] args) {
        final int[] array = {3, 8, 2, 3, 2};
        final LargestNum test = new LargestNum();
        final int res = LargestNum.getLargestNum(array);
        System.out.println(res);
    }
}
