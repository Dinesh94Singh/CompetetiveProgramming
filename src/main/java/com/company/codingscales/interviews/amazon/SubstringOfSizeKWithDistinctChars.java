package com.company.codingscales.interviews.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * As part of Day 1 challenge, your manager has created a word game for you and your teammates to play.
 * The word game begins with your manager writing a string, and a number K on the board.
 * You and your teammates must find a substring of size K such that there is exactly one character that is repeated once.
 * In other words, there should be K - 1 distinct characters in the substring.
 *
 * Write an algorithm to help your teammates find the correct answer. If no such substring can be found, return an empty list;
 * If multiple such substrings exit, return all of them, without repetitions. The order in which the substrings are returned does not matter.
 *
 * Input: it has two arguments:
 *
 * inputString: representing the string written by the manager.
 * num: an integer representing the number K, written by the manager on the board.
 * Output:
 *
 * Return a list of all substrings of inputString with K characters, that have K - 1 distinct character, i.e. exactly one character is repeated,
 * or an empty list if no such substring exists in inputString. The order in which the substrings are returned does not matter.
 * Constraints:
 *
 * The input integer can only be greater than or equal to 0 and less than or equal to 26 (0 <= num <= 26).
 * The input string consists of only lowercase alphabetic characters.
 * Example 1:
 *
 * Input:
 * inputString = awaglk
 * num = 4
 *
 * Output:
 * [awag]
 *
 * Explanation:
 * The substrings are {awag, wagl, aglk}
 * The answer is awag as it has 3 distinct characters in a string of size 4, and only one character is repeated twice.
 * Example 2:
 *
 * Input:
 * inputString = democracy
 * num = 5
 *
 * Output:
 * [ocrac, cracy]
 * Example 3:
 *
 * Input:
 * inputString = wawaglknagagwunagkwkwagl
 * num = 4
 *
 * Output:
 * [awag, naga, gagw, gkwk, wkwa]
 * Similar problems:
 */
public class SubstringOfSizeKWithDistinctChars {
    static List<String> solve(final String s, final int k) {
        List<String> result = new ArrayList<>();
        if (k == 1) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        int currentSize = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            if (currentSize == k) {
                int newValue = map.get(chars[i - k]) - 1;
                if (newValue == 0) {
                    map.remove(chars[i - k]);
                } else {
                    map.put(chars[i - k], newValue);
                }
            } else {
                currentSize += 1;
            }

            if (map.size() == k - 1 && currentSize == k) {
                result.add(s.substring(i - k + 1, i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> res = solve("democracy", 5);
        System.out.println("!! Done !!");
    }
}
