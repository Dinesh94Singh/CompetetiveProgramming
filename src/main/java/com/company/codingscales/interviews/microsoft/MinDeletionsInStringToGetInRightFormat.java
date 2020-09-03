package com.company.codingscales.interviews.microsoft;

import java.util.HashMap;

public class MinDeletionsInStringToGetInRightFormat {
    private static int solve(final String s) {
        // until last occurence of A, find the total number of B's prior to that.
        int numOfAs = 0;
        int numOfBs = 0;

        for(int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (ch == 'A')
                numOfAs ++;
        }

        int res = numOfAs;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A')
                numOfAs--;
            else
                numOfBs++;

            res = Math.min(res, numOfAs + numOfBs); // left over numOfA's and encountered numOfB's
        }

        return res;
    }
    public static void main(final String[] args) {
        System.out.println(solve("BAAABAB"));
        System.out.println(solve("BBABAA"));
        System.out.println(solve("AABBBB"));
    }
}
