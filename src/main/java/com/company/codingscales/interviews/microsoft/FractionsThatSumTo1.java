package com.company.codingscales.interviews.microsoft;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class FractionsThatSumTo1 {
    static class Node { // JavaFx pair
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    private static int solve(int[] x, int[] y) {
        List<BigInteger> X = Arrays.stream(x).mapToObj(each -> BigInteger.valueOf((long) each)).collect(Collectors.toList());
        List<BigInteger> Y = Arrays.stream(x).mapToObj(each -> BigInteger.valueOf((long) each)).collect(Collectors.toList());



        /**
         * 1 / 3 is the first pair
         * Encountered 2/3 => (3 - 2)/3 => 1/3
         *
         * 2/6 is the first pair, with gcd, we store it as 1/3
         * Encountered 4/6 => GCD of 4 & 6 => 2
         * 6/2 => (3 - 2) / 3 => 1/3 (which is already stored in Map)
         */
        int mod = (int) 1e9 + 7;
        int res = 0;
        Map<AbstractMap.SimpleImmutableEntry<BigInteger, BigInteger>, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            BigInteger A = BigInteger.valueOf((long) x[i]);
            BigInteger B = BigInteger.valueOf((long) y[i]);
            BigInteger GCD = A.gcd(B);

            // When Javafx is not available, use this. The comparision happens as per values, instead of hashcode
            AbstractMap.SimpleImmutableEntry<BigInteger, BigInteger> curr = new AbstractMap.SimpleImmutableEntry<BigInteger, BigInteger>(
                    A.divide(GCD),
                    B.divide(GCD)
            );

            BigInteger C = B.divide(GCD).subtract(A.divide(GCD));
            BigInteger D = B.divide(GCD);
            AbstractMap.SimpleImmutableEntry<BigInteger, BigInteger> other = new AbstractMap.SimpleImmutableEntry<>(
                    C,
                    D
            );

            if (map.containsKey(other)) {
                res = (res + map.get(other) % mod) % mod;
            }

            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        solve(new int[]{}, new int[]{});
    }
}
