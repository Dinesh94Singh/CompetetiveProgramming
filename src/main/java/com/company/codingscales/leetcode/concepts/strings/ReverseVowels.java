package com.company.codingscales.leetcode.concepts.strings;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] A = s.toCharArray();

        int i = 0, j = A.length - 1;

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while (i < j) {
            while (i < j && !vowels.contains(s.charAt(i))) {
                i++;
            }

            while (j > i && !vowels.contains(s.charAt(j))) {
                j--;
            }

            swap(A, i, j);
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for(char e : A)
            sb.append(e);
        return sb.toString();
    }

    void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
