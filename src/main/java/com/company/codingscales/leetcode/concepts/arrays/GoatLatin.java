package com.company.codingscales.leetcode.concepts.arrays;

import java.util.HashSet;

public class GoatLatin {
    public String toGoatLatin(String s) {
        char[] A = s.toCharArray();

        int i = 0;
        HashSet<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int wordCount = 1;

        StringBuilder sb = new StringBuilder();
        while (i < A.length) {
            if (vowels.contains(Character.toLowerCase(A[i]))) {
                // add ma at the end

                while (i < A.length && A[i] != ' ') {
                    sb.append(A[i]);
                    i++;
                }

                sb.append("ma");

            } else {
                char ch = A[i];
                i++;
                while (i < A.length && A[i] != ' ') {
                    sb.append(A[i]);
                    i++;
                }

                sb.append(ch);
                sb.append("ma");
            }

            for(int k = 0; k < wordCount; k++) {
                sb.append("a");
            }

            sb.append(" ");
            wordCount++;
            i++;
        }

        return sb.toString().trim();

    }
}
