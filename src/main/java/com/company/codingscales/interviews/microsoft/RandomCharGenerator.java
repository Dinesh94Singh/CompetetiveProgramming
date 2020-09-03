package com.company.codingscales.interviews.microsoft;

import java.util.Random;

public class RandomCharGenerator {
    public void randomCharGen(final StringBuilder sb, final int index) {
        final Random r = new Random();
        char c = '?';
        do {
            c = (char) (r.nextInt(26) + 'a');
        } while ((index > 0 && sb.charAt(index - 1) == c) || (index < sb.length() - 1 && sb.charAt(index + 1) == c));
        sb.replace(index, index + 1, "" + c);
    }

    public String riddleString(final String input) {
        final StringBuilder sb = new StringBuilder(input);
        if (sb.length() == 0) return "";

        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                randomCharGen(sb, i);
            }
        }
        return sb.toString();
    }

    public static void main(final String[] args) {
        final RandomCharGenerator s = new RandomCharGenerator();
        System.out.println(s.riddleString("xy?xz?"));
        System.out.println(s.riddleString("ab?e?mr??"));
        System.out.println(s.riddleString("??????"));
    }
}
