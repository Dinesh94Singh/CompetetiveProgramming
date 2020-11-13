package com.company.codingscales.interviews.goldmansachs;

// TODO: Redo this again. Just a place holder for timebeing. - Referred from - https://leetcode.com/problems/last-substring-in-lexicographical-order/discuss/361022/Java-brute-force
public class LastSubstringInLexicographicalOrder {
    /**
     * bbb…bbbbbba for this case, if we just update i to i + 1,time complexity will downgrade to o(n^2).
     * Let me try to prove why it safely move from i to i + k + 1. For example, for "cabcabx" the matching pattern is 'cab', at 'x' two candidates are mismatching. since 'x' > 'c', wen need move i, that's true we can just move to i + 1. However, as long as 'cab' is matching pattern. both 'a' and 'b' have been visited by j. so we can safely move to i + k + 1. In other words, now j becomes i, i becomes to j. why do you want to go back a visited index? the idea is a little similar with KMP.
     */
    public String lastSubstring(String s) {
        int n = s.length();
        //k is the len when we have two candidates
        //i is the first candidate start position, j is the second one (can not be candidate)
        int i = 0, j= 1, k = 0;
        while (i < n && j < n && k < n) {
            if (i + k >= n || j + k >= n) {
                break;
            }
            // they have same start point, then increase the length
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            } else {
                // now two candidates are different, then which one is larger
                if (s.charAt(i + k) < s.charAt(j + k)) {
                    i = i + k + 1; // j becomes the candidate, i need move forward
                } else {
                    j = j + k + 1; // i becomes the candidate
                }
                if (i == j) {
                    j++; // potational i, j stay at the same position, j move forward(i also can move)
                }
                k = 0; //reset the len
            }
        }
        int l = Math.min(i, j);
        return s.substring(l);
    }


    public String lastSubstringBruteForce(String str) {
        String mx = "";
        char cur = 'a';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= cur && mx.compareTo(str.substring(i)) <= 0) { // the first letter of substring matters,
                cur = str.charAt(i);
                mx = str.substring(i);  // for example, "tabc" is lexicographically larger than "tab"
            }
            while(i != str.length() -1 && str.charAt(i) == str.charAt(i+1)) i++;  // get rid of continuous repeating letters
        }
        return mx;
    }
}
