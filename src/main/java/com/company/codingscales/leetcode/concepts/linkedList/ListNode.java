package com.company.codingscales.leetcode.concepts.linkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(final int val) {
        this.val = val;
    }

    ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {}
}
