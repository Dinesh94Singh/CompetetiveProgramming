package com.company.codingscales.leetcode.concepts.hashmap;

public class CheckIfPairsOfArrayAreDivisibleByK {
    // Similar problem was asked in microsoft O.A, you have to sum two fractions to get the resulting value as 1, where we did gcd.
    // It is a common practice, to use HashMap or Arrayed HM, when ever we see problems related to Pairs.
    public static boolean canArrange(final int[] arr, final int k) {
        final int n = arr.length;
        final int[] freq = new int[k]; // works like hashmap

        for (final int j : arr) {
            final int index = ((j % k) + k) % k; // ideally arr[i] % k should be sufficient, adding + k and % k will result in tighter bound.
            freq[index]++;
        }

        for(int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }

        return freq[0] % 2 == 0;
    }
}
