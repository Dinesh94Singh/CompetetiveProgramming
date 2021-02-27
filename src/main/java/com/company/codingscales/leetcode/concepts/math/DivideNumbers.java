package com.company.codingscales.leetcode.concepts.math;

// linear
// binary search
public class DivideNumbers {
    static class LinearIncrementSolution {
        private long dfs(long N, long D) { // TLE's
            long count = 0;
            while (N > 0) {
                N = N - D;
                count++;
            }

            return count;
        }
    }

    /* Make sure to convert ints to long, to avoid overflow. Math.abs works based on datatype. Make sure to convert and send it */
    // Cannot use * as per question
    static class BinaryIncrementsSolution { //TLE's
        public int divide(int n, int d) {
            long count = 0;
            int numSign = n > 0 ? 1 : -1;
            int denomSign = d > 0 ? 1 : -1;

            int finalSign = numSign * denomSign;

            long N = Math.abs((long) n);
            long D = Math.abs(d);

            count = dfs(N, D);
            System.out.println("N & D are" + N + " " + D);
            System.out.println("Count is " + count + " sign is " + finalSign);
            if (count >= Integer.MAX_VALUE)
                return finalSign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            return finalSign > 0 ? (int) count : (int) count * -1;
        }

        private long dfs(long N, long D) { // refer to bit manupulation ans for iterative solution
            if (N < D)
                return 0;

            long t = D;
            long multiple = 1;

            while ((t + t) <= N) {
                t += t;
                multiple += multiple;
            }

            return multiple + dfs(N - t, D);
        }
    }

    static class BitManipulationSolution {
        /* Each Integer can be represented in powers of 2. Eg: 7 => 0000...00111 */
        /* 1 << shift ==  2 ^ shift */
        /*  if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
            int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
         */
        public int divide(int divident, int divisor) {
            int sign = 1;
            if ((divident > 0 && divisor < 0) || (divident < 0 && divisor > 0)) {
                sign = -sign;
            }

            long numerator = Math.abs((long) divident);
            long denominator = Math.abs((long) divisor);
            long res = 0;
            while (denominator <= numerator) {
                long t = denominator;
                long multiple = 1;
                while (numerator >= t << 1) {
                    t <<= 1; // increase the denominator by power's of 2 - until, the highest multiple of denominator is divisible.
                    multiple <<= 1; // multiple by 2
                }
                numerator -= t;
                res += multiple;
            }

            if (res >= Integer.MAX_VALUE)
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            return sign > 0 ? (int) res : -(int) res;
        }
    }

    public static void main(String[] args) {
        long multiple = 1;
        for(int i = 0; i < 5; i++) { // powers of 2;
            System.out.println(multiple);
            multiple <<= 1;
        }
    }
}
