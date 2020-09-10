package com.company.codingscales.leetcode.concepts.design;

public class ReadNCharactersGivenRead4MultipleTimes {
    static abstract class Interactive {
        static int read4(final char[] temp) {
            return 0;
        }
    }

    private final char[] cache = new char[4];
    private int readIndex = 0;
    private int cacheSize = 0;

    public int read(final char[] buf, int n) {
        int writeIndex = 0;
        // Write from cache to buffer
        while (readIndex < cacheSize && writeIndex < n) {
            buf[writeIndex++] = cache[readIndex++];
        }

        // Cache was written, load new data to cache, when we need the remaining k bits info
        readIndex = 0;
        while(writeIndex < n) {
            cacheSize = Interactive.read4(cache);
            if (cacheSize == 0) {
                break;
            }

            for(int i = 0; i < cacheSize; i++) {
                cache[writeIndex++] = cache[readIndex++];
                n--;
            }
        }

        return writeIndex;
    }
}
