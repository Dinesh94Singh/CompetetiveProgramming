package com.company.codingscales.leetcode.concepts.segmentTree;

public class SegmentTree {
    /* Segment Tree */
    int[] tree;

    SegmentTree(int size) {
        tree = new int[size];
    }

    /**
     * Convert arr to a Segment tree
     * @param arr - input arr
     * @param treeIdx - treeIdx
     * @param lo - left bound
     * @param hi - right bound
     */
    void buildSegmentTree(int[] arr, int treeIdx, int lo, int hi) {
        if (lo == hi) {
            tree[treeIdx] = arr[lo];
            return;
        }

        int mid = lo + (hi - lo) / 2;
        buildSegmentTree(arr, 2 * treeIdx, lo, mid);
        buildSegmentTree(arr, 2 * treeIdx + 1, mid + 1, hi);

        tree[treeIdx] = tree[2 * treeIdx] + tree[2 * treeIdx + 1]; // union/merge.
    }

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
}
