package com.company.codingscales.leetcode.concepts.linkedList;

import javafx.util.Pair;

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        Pair<ListNode, ListNode> nodes = find(list1, a, b);
        ListNode prev = nodes.getKey();
        ListNode tail = nodes.getValue();

        ListNode list2Tail = getTail(list2);

        if (prev != null) {
            prev.next = list2;
        }

        if (list2Tail != null) {
            list2Tail.next = tail;
        }

        return list1;
    }

    // a and b are pos not values
    Pair<ListNode, ListNode> find(ListNode list, int a, int b) {
        ListNode start = list;
        ListNode end = list;
        ListNode prev = null;
        int idx = 0;
        while (end != null) {
            if (idx == a) { // start is also at end; prev is at one pos behind
                while (end != null && idx != b) {
                    idx++;
                    end = end.next;
                }

                return new Pair<>(prev, end.next); // end.next would have the next value
            } else {
                idx++;
                prev = start;
                start = start.next;
                end = end.next;
            }
        }

        return new Pair<>(null, null);
    }

    ListNode getTail(ListNode list) {
        if (list == null)
            return null;
        ListNode curr = list;
        ListNode prev = null;

        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
}
