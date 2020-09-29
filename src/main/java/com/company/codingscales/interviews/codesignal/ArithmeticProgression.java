package com.company.codingscales.interviews.codesignal;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class ArithmeticProgression {
    // Doesn't work
    final static int arithmeticProgression(final int[] a, final int[] arr2) {
        if(a.length ==0)return 0;
        int n =a.length, m = arr2.length;
        HashSet<Integer> uniqueElements = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        final int[] arr = new int[n+m];

        System.arraycopy(a,0,arr,0,n);
        System.arraycopy(arr2,0,arr,n,m);

        Arrays.sort(arr);

        HashMap<Pair<Integer, Integer>, Integer> pairMap = new HashMap<>();
        HashMap<Pair<Integer, Integer>, Integer> pairMap2 = new HashMap<>();
        int result =0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                int count = 0;
                if (uniqueElements.contains(arr[i])) {
                    count++;
                }

                Pair<Integer, Integer> p = new Pair<>(j, diff);
                for(Map.Entry<Pair<Integer, Integer>, Integer> entry : pairMap.entrySet()) {
                }
                if (pairMap.containsKey(p)) {
                    Pair<Integer, Integer> anotherPair = new Pair<>(i, diff);
                    pairMap.put(anotherPair, pairMap.get(p) + 1);
                    pairMap2.put(anotherPair, pairMap.get(p) + count);
                } else {
                    if (uniqueElements.contains(arr[j])) {
                        count += 1;
                    }

                    Pair<Integer, Integer> anotherPair = new Pair<>(i, diff);
                    pairMap.put(anotherPair, 2);
                    pairMap2.put(anotherPair, count);
                }
            }
        }

        if(result < n) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 4, 8, 16};
        int[] b = {0, 2, 6, 12, 14, 20};

        System.out.println("\n " + arithmeticProgression(a, b));
        a = new int[]{5, 7, 13, 14};
        b = new int[]{9, 11, 15};

        System.out.println("\n " + arithmeticProgression(a, b)); // -1
    }
}
