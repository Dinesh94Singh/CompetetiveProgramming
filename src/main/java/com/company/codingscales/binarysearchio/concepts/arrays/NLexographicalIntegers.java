package com.company.codingscales.binarysearchio.concepts.arrays;

import java.util.ArrayList;
import java.util.List;

public class NLexographicalIntegers {
    public static int[] solve(int n) {
        int c = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            System.out.printf("%d \n", c);
            list.add(c);
            c = c * 10;

            while (c > n) {
                System.out.println("Inside");
                System.out.printf("%d \n", c);
                c /= 10;
                c++;
                while (c % 10 == 0) {
                    c /= 10;
                }
            }
            System.out.println("\n\n");
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        solve(12);
    }
}
