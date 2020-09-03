package com.company.codingscales.interviews.microsoft;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class ParticleVelocity {
    private static int solve(final int[] a) {
        if (a.length < 3) return -1;
        int totalPeriods = 0;
        for (int i = 0; i < a.length; i++) {
            for (int count = 0; i + 2 < a.length && a[i + 1] - a[i] == a[i + 2] - a[i + 1]; i++) {
                count++;
                totalPeriods += count; // basically count * diff;
            }
        }
        return totalPeriods < 1_000_000_000 ? totalPeriods : -1;
    }

    public static void main(final String[] args) {
        System.out.println(solve(new int[] {1, 3, 5, 7, 9}));
        System.out.println(solve(new int[] {7, 7, 7, 7, 7}));
        System.out.println(solve(new int[] {3, 1, -5, -9}));
        System.out.println(solve(new int[] {0, 1}));
        System.out.println(solve(new int[] {1, 1, 2, 5, 7}));
        System.out.println(solve(LeetCodeInputHelpers.stringToIntArray("[1,3,5,7,9]")));
    }
}
