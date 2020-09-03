package com.company.codingscales.leetcode.concepts.strings;

public class MultipleStrings {
    public static String multiply(final String num1, final String num2) {
        final int[] res = new int[num1.length() + num2.length()];
        final StringBuilder n1 = new StringBuilder(num1);
        final StringBuilder n2 = new StringBuilder(num2);

        n1.reverse();
        n2.reverse();

        int offset = res.length - 1;

        for(int i = 0; i < n1.length(); i++) {
            int temp = offset;
            for(int j = 0; j < n2.length(); j++) {
                final int prod = Character.getNumericValue(n1.charAt(i)) * Character.getNumericValue(n2.charAt(j));
                res[temp] += prod;

                res[temp - 1] += res[temp] / 10;
                res[temp] = res[temp] % 10;
                temp--;
            }
            offset--;
        }

        int i = 0;
        for(; i < res.length; i++) {
            if (0 != res[i]) { break; }
        }

        // Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(""));
        final StringBuilder ans = new StringBuilder();
        for(; i < res.length; i++) {
            ans.append(res[i]);
        }

        return ans.toString();
    }

    public static void main(final String[] args) {
        System.out.println(multiply("456", "123"));
    }
}
