package com.company.codingscales.geeksforgeeks.bitMagic;

public class checkIfKthBitIsSet {
    public boolean checkUsingLeftShift(final int n, final int k) {
        return (n & (n << (k - 1))) == 1;
    }

    public boolean checkUsingRightShift(final int n, final int k) {
        return ((n >> (k - 1)) & 1) == 1;
    }
}
