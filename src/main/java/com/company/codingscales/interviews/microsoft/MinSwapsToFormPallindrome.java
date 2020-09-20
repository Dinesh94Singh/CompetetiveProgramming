package com.company.codingscales.interviews.microsoft;


public class MinSwapsToFormPallindrome {
    public static void main(final String[] args) {
        System.out.println(getNoOfSwaps("ntaiain"));
    }

    private static int getNoOfSwaps(final String s) {
        if(s == null || s.isEmpty()) return -1;
        int totalSwaps = 0;

        if(isShuffledPalindrome(s)) {
            final char[] chars = s.toCharArray();
            int p1 = 0, p2 = chars.length - 1;

            while(p2 > p1) {
                if(chars[p1] != chars[p2]) {
                    int k = p2;
                    while(k > p1 && chars[k] != chars[p1]) k--;

                    if(k == p1) { //When no matching character found
                        swap(chars, p1, p1 + 1);
                        totalSwaps++;

                    } else { //When Matching character found swap until K reaches p2 position
                        while(k < p2) {
                            swap(chars, k, k + 1);
                            totalSwaps++;
                            k++;
                        }
                        p1++; p2--;
                    }
                } else {
                    p1++; p2--; //When the characters are equal move on
                }
            }
            return totalSwaps;
        }
        else return -1;
    }

    private static void swap(final char[] chars, final int k, final int i) {
        final char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }

    private static boolean isShuffledPalindrome(final String s) {
        final int [] occurrence = new int[26];
        int oddCount = 0;

        for(int i = 0; i < s.length(); i++) occurrence[s.charAt(i) - 'a']++;
        for (final int value : occurrence) if (value % 2 != 0) oddCount++;
        return oddCount <= 1;
    }
}
