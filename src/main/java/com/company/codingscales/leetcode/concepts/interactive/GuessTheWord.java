package com.company.codingscales.leetcode.concepts.interactive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Fuck this problem
public class GuessTheWord {
    static class Master {
        int guess(final String secret) {
            return 0;
        }
    }

    static int match(final String curr, final String other) {
        int count = 0;
        for(int i = 0; i < 6; i++) {
            if (curr.charAt(i) == other.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    static void findSecretWord(String[] words, final Master master) {
        final HashMap<String, Integer> cntr = new HashMap<>();
        for (final String each : words) {
            for (final String other : words) {
                if (match(each, other) == 0) {
                    // none of the chars match
                    cntr.put(each, cntr.getOrDefault(each, 0) + 1);
                }
            }
        }

        for(int i = 0; i < 10; i++) {
            int minimum = Integer.MAX_VALUE;
            String guess = "";

            for(final String each : words) {
                if (cntr.getOrDefault(each, 0) < minimum) {
                    guess = each;
                    minimum = cntr.getOrDefault(each, 0);
                }
            }

            final int x = master.guess(guess); // this guess word is matched the least with other words
            List<String> wordList = new ArrayList<>();
            for(final String each : words) {
                if (match(each, guess) == x) {
                    wordList.add(each);
                }
            }

            if (x == 6)
                break; // we should hv made the call
            words = wordList.toArray(new String[0]); // toArray returns object
        }
    }
}
