package com.company.codingscales.interviews.microsoft;

public class CompressString {
    private static int helper(final char[] chars, final char ch, int p1, final int count) {
        chars[p1] = ch;
        if (count == 1) {
            p1++;
            return p1;
        }
        int j = 1;
        for (final char c : ("" + count).toCharArray()) {
            chars[p1 + j] = c;
            j++;
        }
        p1 = p1 + j;
        return p1;
    }

    public static int compress(final char[] chars) {
        int p1 = 0;//to know at which place we need to place th enew char
        int p2 = 0;//for moving forward
        char ch = chars[0];
        final int j = 1;
        int count = 0;

        for (p2 = 0; p2 < chars.length; p2++) {
            if (chars[p2] == ch) {
                count++;
            } else {
                p1 = helper(chars, ch, p1, count);
                ch = chars[p2];
                count = 1;
            }
        }


        p1 = helper(chars, ch, p1, count);
        System.out.println(chars);
        return p1;
    }

    public static void main(final String[] args) {
//        char[] ch_arry = new char[]{'a', 'b', 'c'};
//        System.out.println(compress(ch_arry));
        final char[] ch_arry = new char[]{'a','a','a','a','a','b','b','c','c'};
        System.out.println(compress(ch_arry));
    }
}
