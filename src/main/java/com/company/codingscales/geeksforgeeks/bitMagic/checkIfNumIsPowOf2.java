package com.company.codingscales.geeksforgeeks.bitMagic;

public class checkIfNumIsPowOf2 {
    boolean solve(final int n) {
        // brian & kerninghan algorithm
        if (n == 0) return true;
        return (n & (n - 1)) == 0;
    }
}
