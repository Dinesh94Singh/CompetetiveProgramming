package com.company.codingscales.leetcode.concepts.strings;

public class CheckIfTwoStringsAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();

        for(String each : word1)
            w1.append(each);

        for(String each : word2)
            w2.append(each);

        return w1.toString().equals(w2.toString());
    }
}
