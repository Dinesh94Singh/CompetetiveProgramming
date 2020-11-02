package com.company.codingscales.interviews.amazon;

import java.util.HashMap;

public class MusicPairs {
    // TODO: Read before interview: Always ask the interviewer, about the q about remainder being 0;
    private static int solve(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums) {
            n = n % 60;
            int target = (60 - n) % 60;
            res += map.getOrDefault(target, 0);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{60, 60, 60}));
        System.out.println(solve(new int[]{37, 23, 60}));
        System.out.println(solve(new int[]{30, 20, 150, 100, 40}));
        System.out.println(solve(new int[]{10, 50, 90, 30}));
    }
}
