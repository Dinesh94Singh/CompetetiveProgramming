package com.company.codingscales.interviews.microsoft;

import java.util.HashSet;

public class LargetBothKAndKMinus1 {
    private static int solve(final int[] arr) {
        final HashSet<Integer> hs = new HashSet<>();
        int res = 0;
        for (final int a: arr) {
            hs.add(a);
            if(hs.contains(-a)) {
                res = Math.max(res, Math.abs(a));
            }
        }

        return res;

    }
    public static void main(final String[] args) {
        System.out.println(solve(new int[] {3, 2, -2, 5, -3}));
        System.out.println(solve(new int[] {1, 2, 3, -4}));
    }
}
