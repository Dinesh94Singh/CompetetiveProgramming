package com.company.codingscales.leetcode.concepts.strings;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int i = n % 26;
            sb.insert(0, (char) (i + 'A'));
            n /= 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(702));
    }
}
