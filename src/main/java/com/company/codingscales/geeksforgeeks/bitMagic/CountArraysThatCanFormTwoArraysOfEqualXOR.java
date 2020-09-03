package com.company.codingscales.geeksforgeeks.bitMagic;

public class CountArraysThatCanFormTwoArraysOfEqualXOR {
    static int lg = 31;

    static class TrieNode {
        TrieNode[] children;
        int sum_of_indexes;
        int number_of_indexes;

        TrieNode() {
            children = new TrieNode[2];
            this.children[0] = null;
            this.children[1] = null;
            this.sum_of_indexes = 0;
            this.number_of_indexes = 0;
        }
    }

    static void insert(TrieNode node, final int num, final int index) {
        for (int bits = lg; bits >= 0; bits--) {
            final int curr_bit = (num >> bits) & 1;
            if (node.children[curr_bit] == null) {
                node.children[curr_bit] = new TrieNode();
            }
            node = node.children[curr_bit];
        }

        node.sum_of_indexes += index;
        node.number_of_indexes++;
    }

    static int query(TrieNode node, final int num, final int index) {
        for (int bits = lg; bits >= 0; bits--) {
            final int curr_bit = (num >> bits) & 1;

            if (node.children[curr_bit] == null) {
                return 0;
            }

            node = node.children[curr_bit];
        }

        final int sz = node.number_of_indexes;

        final int sum = node.sum_of_indexes;

        final int ans = (sz * index) - (sum);

        return ans;
    }

    public int countTriplets(final int[] arr) {
        final int n = arr.length;
        int curr_xor = 0;
        int number_of_triplets = 0;

        final TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            final int x = arr[i];
            insert(root, curr_xor, i);
            curr_xor ^= x;
            number_of_triplets += query(root, curr_xor, i);
        }

        return number_of_triplets;
    }

    public int countTripletsDp(final int[] arr) {
        final int[] prefix = new int[arr.length + 1];
        for(int i=1;i<arr.length + 1;i++) {
            prefix[i] = arr[i-1] ^ prefix[i-1];
        }

        int res = 0;
        for (int i = 0; i < arr.length + 1; ++i)
            for (int j = i + 1; j < arr.length + 1; ++j)
                if (prefix[i] == prefix[j])
                    res += j - i - 1;
        return res;
    }
}
