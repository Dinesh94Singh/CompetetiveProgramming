package com.company.codingscales.interviews.microsoft;

import java.util.*;


public class CountOfHours {
    static void solve(List<Integer> nums, List<Boolean> used, int index, int hour, int min, HashSet<Integer> res) {
        if (index == nums.size()) {
            res.add(hour * 60 + min);
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            if (!used.get(i)) {
                used.set(i, true);
                if (index < 2)
                    solve(nums, used, index + 1, hour * 10 + nums.get(i), min, res);
                else
                    solve(nums, used, index + 1, hour , nums.get(i) + 10 * min, res);

                used.set(i, false);
            }
        }
    }

    static int countOfHours(int A, int B, int C, int D) {
        List<Integer> nums = Arrays.asList(A, B, C, D);
        List<Boolean> used = new ArrayList<>(4);
        HashSet<Integer> res = new HashSet<>();
        solve(nums, used, 0, 0, 0, res);
        return res.size();
    }

    public static void main(String[] args) {
    }
}
