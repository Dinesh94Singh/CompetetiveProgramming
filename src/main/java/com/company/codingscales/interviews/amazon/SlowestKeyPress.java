package com.company.codingscales.interviews.amazon;

import java.util.List;

public class SlowestKeyPress {
    /**
     * Initialize the maxDifference and bestChar with the first character.
     * Start iterating from 2nd character to nth character.
     * Find the difference between every adjacent character (i and i-1th character)
     * If the current difference is greater than maxDifference calculated so far. Or the difference is same but the current character is greater than bestChar, update the difference and bestChar.
     * Return the bestChar.
     * @return
     */
    public char slowestKeyPress(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDifference = releaseTimes[0];
        char bestChar = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int difference = releaseTimes[i] - releaseTimes[i-1];

            if (difference > maxDifference || (difference == maxDifference && keysPressed.charAt(i) > bestChar)) {
                maxDifference = difference;
                bestChar = keysPressed.charAt(i);
            }
        }
        return bestChar;
    }

    char slowestKey(List<List<Integer>> keyTimes) {
        int n = keyTimes.size();
        for(int i = n - 1; i > 0; i--) {
            keyTimes.get(i).set(1, keyTimes.get(i).get(1) - keyTimes.get(i-1).get(1));
        }

        keyTimes.sort((curr, other) -> (curr.get(1) - other.get(1)));
        int x = keyTimes.get(n-1).get(0) + 97;
        return (char) x;
    }
}
