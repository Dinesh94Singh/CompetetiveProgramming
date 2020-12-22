package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.TreeMap;

/**
 * Instead of storing the entire array in the snapshot, we are only storing the changes made.
 * Each Index in indexSnaps represent the versionHistory of the index
 * We store the value of that index, each time we call the function set
 *
 * While getting, there could have been snapshots in b/w. So, return the lower-bound from the treeMap's representing the value for that snapshot
 */
public class SnapshotArray {
    TreeMap<Integer, Integer>[] snaps;
    int snapIdx = 0;

    public SnapshotArray(int length) {
        snaps = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            snaps[i] = new TreeMap<>();
            snaps[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        snaps[index].put(snapIdx, val);
    }

    public int snap() {
        snapIdx++;
        return snapIdx - 1;
    }

    public int get(int index, int snap_id) {
        return snaps[index].floorEntry(snap_id).getValue();
    }
}
