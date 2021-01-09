package com.company.codingscales.leetcode.concepts.strings;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0, j = arr.length - 1;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (i <= j) {
            char ch1 = arr[i];
            char ch2 = arr[j];

            if (i == j) {
                sb1.append(ch1);
                break;
            } else if (!Character.isAlphabetic(ch1)) {
                sb1.append(ch1);
                i++;
            } else if (!Character.isAlphabetic(ch2)) {
                sb2.insert(0, ch2);
                j--;
            } else {
                sb1.append(ch2);
                sb2.insert(0, ch1);
                i++;
                j--;
            }
        }

        return sb1.toString() + sb2.toString();
    }
}
