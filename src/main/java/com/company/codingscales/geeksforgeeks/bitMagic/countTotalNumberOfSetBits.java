package com.company.codingscales.geeksforgeeks.bitMagic;

public class countTotalNumberOfSetBits {
    // O(total bit count)
    public int count(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) { count ++; } // can be replaced by count += (n & 1)
            n >>= 1;
        }
        return count;
    }

    // O(set bits)
    public int brianAndKerninghan(int n) {
        int count = 0;
        while (n > 0) {
            n = (n & (n - 1)); // gets the left most set bit.
            count++;
        }

        return count;
    }

    static int []table = new int[256];
    public static void initialize() { // preprocessing
        // To initially generate the table algorithmically:
        table[0] = 0;
        for (int i = 0; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
    }

    // O(1), but requires preprocessing
    public int lookUpTable(final int n) {
        // 32 bit number -> into 8bit chunks -> 0 - 2^7 - 1 (255) where 0xff hexdecimal representation of last 8 bits, by end, you end up with up only 8 bits
        return table[n & 0xff] + table[(n >> 8) & 0xff] + table[(n >> 16) & 0xff] + table[n >> 24];
    }

    public static void main(final String[] args) {
        final countTotalNumberOfSetBits c = new countTotalNumberOfSetBits();
        System.out.println(c.count(2));
    }
}
