package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.Arrays;

public class FractionAdditionAndSubtraction {
    public static String fractionAddition(final String expression) {
        final String[] nums = expression.split("(?=[+-])");
        // final String[] N = expression.split("(\\+)|(-)");
        // final String[] nums = Arrays.copyOfRange(N, 1, N.length);
        int[] res = {0, 1};
        for(final String num : nums) {
            res = crossProduct(res, serialize(num));
        }

        return res[0] + "/" + res[1];
    }

    private static int[] crossProduct(final int[] A, final int[] B) {
        final int numerator = A[0] * B[1] + B[0] * A[1];
        final int denominator = A[1] * B[1];

        final int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        return new int[] {numerator / gcd, denominator / gcd};
    }

    // euclidean algorithm - https://en.wikipedia.org/wiki/Euclidean_algorithm
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    private static int gcdIterative(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    private static int[] serialize(final String num) {
        return Arrays.stream(num.split("/")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2"));
    }
}
