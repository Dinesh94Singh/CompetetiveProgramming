package com.company.codingscales.interviews.microsoft;

import java.util.ArrayList;

public class Debug {
    public static String[] solution(final int N, final int K) {
        if (N == 0 || K == 0) { // add k == 0;
            return new String[] {""};
        }
        final ArrayList<String> result = new ArrayList<String>();
        for (final String p : solution(N - 1, K - 1)) {
            for (final char l : new char[] {'a', 'b', 'c'}) {
                final int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        final int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static void main(final String[] args) {
        for(final String s: solution(4, 2))
            System.out.println(s);
    }
}
