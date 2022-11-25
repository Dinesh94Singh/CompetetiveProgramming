package com.company.codingscales.leetcode.concepts.strings;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        // ab, ba

        if (s.length() != goal.length())
            return false;

        if (s.equals(goal)) {
            int[] A = new int[26];
            for(char ch : s.toCharArray()) {
                A[ch - 'a']++;
            }

            for(int c : A) { // abcd // abcd -> if you swap, it will cause issue. To not cause, issues, swap with same char
                if (c > 1)
                    return true;
            }

            return false;

        } else {
            int first = -1, second = -1;
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }

            return first != -1 && second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);

        }
    }
}
