package com.company.codingscales.leetcode.concepts.design;

import static com.company.codingscales.leetcode.concepts.design.ReadNCharactersGivenRead4MultipleTimes.Interactive.read4;

public class ReadNCharactersGivenRead4MultipleTimes {
    static abstract class Interactive {
        static int read4(final char[] temp) {
            return 0;
        }
    }

    char[] temp = new char[4];
    int idx;
    int buf_size;
    public int read(char[] buf, int n) {
        int size = 0;
        while (n > 0 && buf_size > 0) {
            buf_size--;
            buf[size++] = temp[idx++];
            n--;
        }
        if (buf_size == 0)
            idx = 0; // reset back to zero
        while (n > 0) {
            // buf_size is already 0
            buf_size = read4(temp);
            idx = 0; // if you are reading then reset back to 0.
            if (buf_size == 0)
                break;

            while(n > 0 && buf_size > 0) {
                //System.out.println("Current n is  " + n + " , buf size is " + buf_size + ", Length of buf " + buf.length + ", length of tmp" + temp.length + " idx is " + idx);
                buf[size++] = temp[idx++];
                buf_size--;
                n--;
            }
        }

        return size;
    }

    static class RedidSolution {
        char[] t = new char[4];

        int idx = 0;
        int size = 0;

        public int read(char[] buf, int n) {
            int k = 0;

            while (n-- > 0) {
                if (idx == size) {
                    size = read4(t);
                    idx = 0;
                }

                if (size == 0)
                    break;

                buf[k++] = t[idx++];
            }

            return k;
        }
    }
}
