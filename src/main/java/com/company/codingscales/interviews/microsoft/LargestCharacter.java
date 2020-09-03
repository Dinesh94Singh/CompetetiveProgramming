package com.company.codingscales.interviews.microsoft;

public class LargestCharacter {
    public static void main(final String[] args) {
        System.out.println(largestCharacter("admeDCAB"));
    }
    public static String largestCharacter(final String s) {
        // record each char's uppercase or lowercase
        final boolean[] uppers = new boolean[26];
        final boolean[] lowers = new boolean[26];
        final char[] arr = s.toCharArray();
        for (final char cur: arr) {
            if (Character.isLowerCase(cur)) lowers[cur-'a'] = true;
            if(Character.isUpperCase(cur)) uppers[cur-'A'] = true;
        }
        // visit from uppercase's high index
        for (int i=25; i>=0; i--) {
            // check both its uppercase and lowercase exist or not
            if (uppers[i]&&lowers[i]) {
                return (char)(i+'A')+"";
            }
        }
        return "NO";
    }
}
