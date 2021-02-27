package com.company.codingscales.leetcode.concepts.math;

public class CountOfCoPrimesBetween1AndN {
    // Eulers Algorithm to find GCD in O(LogN) TC
    static int gcd(int a, int b) {
        // Base Case
        if (b == 0)
            return b;

        // Recursive GCD
        return gcd(b, a % b);
    }

    int phiBruteForce(int n) {
        // Iterate over [1, N]
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (gcd(i, n) == 1) {
                count++;
            }
        }
        return count;
    }

    // Refer to Fundamental book for explanation on how we followed euler's property to achieve this.
    int phiUsingfactorization(int n) { // O(root(n))
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }

    int phiUsingSieveOfEratosthenes(int n) { // O(NLogN)
        int[] phi = new int[n + 1];
        phi[0] = 0;
        phi[1] = 1;
        for (int i = 2; i <= n; i++)
            phi[i] = i;

        for (int i = 2; i <= n; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= n; j += i)
                    phi[j] -= phi[j] / i;
            }
        }

        return phi[phi.length];
    }

    int phiUsingDivisorSumProperty(int n) {
        int[] phi = new int[n + 1];
        phi[0] = 0;
        phi[1] = 1;
        for (int i = 2; i <= n; i++)
            phi[i] = i - 1;

        for (int i = 2; i <= n; i++)
            for (int j = 2 * i; j <= n; j += i)
                phi[j] -= phi[i];

        return phi[phi.length - 1];
    }
}