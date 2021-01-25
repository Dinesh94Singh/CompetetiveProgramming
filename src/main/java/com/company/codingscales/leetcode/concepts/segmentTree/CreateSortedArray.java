package com.company.codingscales.leetcode.concepts.segmentTree;

public class CreateSortedArray {
    /* Segment Tree */
    int[] tree;

    /**
     * Queries the Segment tree for the val for range A[i: j]
     * @param treeIdx idx of each tree node
     * @param i start of range idx
     * @param j end of range idx
     * @param lo start of array index
     * @param hi end of array index
     * @return tree node val.
     */
    private int query(int treeIdx, int i, int j, int lo, int hi) {
        if (i > hi || j < lo) // outside range
            return 0; // represent null in segment tree

        if (lo >= i && hi <= j) // node representing the range is found
            return tree[treeIdx]; // return the node res

        int mid = lo + (hi - lo) / 2; // partial overlap

        /**
        if (i > mid) // the other half is null
            return query(2 * treeIdx + 1, mid + 1, hi, i, j);
        else if (j <= mid) // the other half is null
            return query(2 * treeIdx, lo, mid, i, j);
         **/

        return query(2 * treeIdx, i, j, lo, mid) + query(2 * treeIdx + 1, i, j, mid + 1, hi);
    }

    /**
     * Reason for using segment tree is helpful because of update operation. It will also update all the elements
     * present in the path, while reaching the one, you are trying to update.
     *
     * Updates the Segment tree with delta. The path from root to leaf node having the arrIdx is also modified.
     * @param treeIdx idx of each tree node
     * @param delta update val
     * @param lo start of array index
     * @param hi end of array index
     * @param arrIdx idx for which the value is getting updated.
     */
    void update(int treeIdx, int delta, int lo, int hi, int arrIdx) {
        if (arrIdx < lo || arrIdx > hi)
            return;

        if (lo == hi) {
            tree[treeIdx] += delta;
            return;
        }

        int mid = lo + (hi - lo) / 2;

        /**
        if (arrIdx > mid)
            update(2 * treeIdx + 1, delta, mid + 1, hi, arrIdx);
        else if (arrIdx <= mid)
            update(2 * treeIdx, delta, lo, mid, arrIdx);
         **/

        update(2 * treeIdx, delta, lo, mid, arrIdx);
        update(2 * treeIdx + 1, delta, mid + 1, hi, arrIdx);

        tree[treeIdx] = tree[2 * treeIdx] + tree[2 * treeIdx + 1]; // union/merge.
    }

    /* Problem Sol */
    public int createSortedArray(int[] A) {
        tree = new int[400004];
        long ans = 0;
        int max = (int) (1e5 + 1);
        int mod = (int) 1e9 + 7;

        for (int a : A) {
            ans += Math.min(
                    query(1, 0, a - 1, 0, max),
                    query(1, a + 1, max, 0, max)
            );
            ans %= mod;
            update(1, 1, 0, max, a);
        }

        return (int) ans;
    }
}
