package com.company.codingscales.geeksforgeeks.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
    s1 = ABAA
    s2 = AAAB

    Naive approach
        In the following example, you have to check for each occurrences of a's and continue doing modular operations
        1. Build a hm of char - occurrences index (you only need to have the 1st char occurrences i believe)
        2. loop through the other string and find each occurrences of that char from the hm -> create substring till end, if not the required length, add the remaining length from 0th index
        3. to avoid access string's you can compare till the end and continue => Abstract this as function
        4. if you reach till the end of the the s2 -> return true, else try all occurrences and return false
 */
public class check2StringAreRotationsOfEachOther {
    boolean solve(String s1, final String s2) {
        s1 = s1.concat(s1);
        return s1.contains(s2); // s1.indexOf(s2) >= 0
    }
}
