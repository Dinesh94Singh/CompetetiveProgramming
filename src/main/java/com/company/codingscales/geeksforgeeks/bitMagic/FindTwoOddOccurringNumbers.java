package com.company.codingscales.geeksforgeeks.bitMagic;

import com.company.codingscales.templates.Pair;
import org.w3c.dom.ls.LSOutput;

public class FindTwoOddOccurringNumbers {
    public static Pair<Integer, Integer> solve(final int[] arr) {
        // number xored with itself is 0
        // number xored with 0 is number itself
        int xor = 0;
        for(final int a: arr) { xor ^= a; }

        final int setBit = xor & (~(xor - 1));
        int res1 = 0, res2 = 0;
        for(final int a : arr) {
            if ((a & setBit) != 0) {
                res1 ^= a;
            } else {
                res2 ^= a;
            }
        }

        return new Pair<Integer, Integer>(res1, res2);
    }

    public static void main(final String[] args) {
        final Pair<Integer, Integer> res = solve(new int[]{1, 1, 2, 2, 3, 4, 4, 4, 4, 5});
        System.out.println(res.getFirst() + " -> " + res.getSecond());
    }
}
