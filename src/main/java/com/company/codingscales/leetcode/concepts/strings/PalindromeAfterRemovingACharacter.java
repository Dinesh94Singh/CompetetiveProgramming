package com.company.codingscales.leetcode.concepts.strings;

public class PalindromeAfterRemovingACharacter {
    static boolean isPalindrome(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }

        return true;
    }

    public boolean validPalindrome(String str) {
        int low = 0, high = str.length() - 1;
        while (low < high) {

            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                if (isPalindrome(str, low + 1, high))
                    return true;
                if (isPalindrome(str, low, high - 1))
                    return true;
                return false;
            }
        }
        return true;
    }
}
