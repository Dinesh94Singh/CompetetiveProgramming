package com.company.codingscales.leetcode.concepts.design;

// Most asked facebook question
public class ReadNCharactersGivenRead4 {
    static abstract class Interactive {
        static int read4(final char[] temp) {
            return 0;
        }
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public static int read(final char[] buf, int n) {
        int writeIndex = 0;
        final char[] temp = new char[4];
        while (n > 0) {
            final int charRead = Interactive.read4(temp);
            if (charRead == 0) {
                break;
            }
            for(int i = 0; i < charRead; i++) {
                buf[writeIndex++] = temp[i];
                n--;
            }
        }
        return writeIndex;
    }
}
