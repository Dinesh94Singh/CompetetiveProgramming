package com.company.codingscales.leetcode.concepts.dynamicProgramming.minimax;

import java.util.Arrays;
import java.util.HashMap;

public class CanIWin {
    private boolean recHelper(int[] nums, boolean[] used, int desiredTotal, HashMap<String, Boolean> map) {
        if (desiredTotal <= 0) {
            return false;
        }
        String key = Arrays.toString(used);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!recHelper(nums, used, desiredTotal - nums[i], map)) {
                    used[i] = false;
                    map.put(key, true);
                    return true;
                }
                used[i] = false;
            }
        }
        map.put(key, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }

        if ((maxChoosableInteger * (maxChoosableInteger + 1) / 2) < desiredTotal) {
            return false;
        }

        boolean[] used = new boolean[maxChoosableInteger];
        int[] nums = new int[maxChoosableInteger];

        for (int i = 0; i < maxChoosableInteger; i++) {
            nums[i] = i + 1;
        }

        return recHelper(nums, used, desiredTotal, new HashMap<String, Boolean>());
    }
}
