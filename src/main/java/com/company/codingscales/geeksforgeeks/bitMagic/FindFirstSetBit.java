package com.company.codingscales.geeksforgeeks.bitMagic;

public class FindFirstSetBit {
    public static int getFirstSetBitPos(final int n){
        if (n == 0) { return 0; }
        int k = 1;
        while(true) {
            if ((n & (1 << k - 1)) == 1) {
                return k;
            } else {
                k++;
            }
        }

        // can be simplified to ((int) Math.log(n & (-n)) / Math.log(2)) + 1;
    }

    public static void main(final String[] args) {
        System.out.println(getFirstSetBitPos(2));
        System.out.println(getFirstSetBitPos(5));
        System.out.println(getFirstSetBitPos(20));
    }
}
