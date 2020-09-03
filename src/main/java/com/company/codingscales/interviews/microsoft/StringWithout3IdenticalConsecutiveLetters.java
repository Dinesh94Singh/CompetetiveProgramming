package com.company.codingscales.interviews.microsoft;

public class StringWithout3IdenticalConsecutiveLetters {
    public static String solve(final String s) {
        final StringBuilder sb = new StringBuilder(s);

        char ch = sb.charAt(0);
        int count = 1;
        int end = 1;
        final StringBuilder res = new StringBuilder();
        res.append(ch);

        while (end < sb.length()) {
           if (sb.charAt(end) == ch) {
               count++;
               if (count >= 3) {
                   end++;
                   continue;
               } else {
                   res.append(ch);
               }
           } else {
               ch = sb.charAt(end);
               count = 1;
               res.append(ch);
           }
           end++;
        }

        return res.toString();
    }

    public static void main(final String[] args) {
        System.out.println(solve("eedaaad"));
        System.out.println(solve("xxxtxxx"));
        System.out.println(solve("uuuuxaaaaxuuu"));
    }
}
