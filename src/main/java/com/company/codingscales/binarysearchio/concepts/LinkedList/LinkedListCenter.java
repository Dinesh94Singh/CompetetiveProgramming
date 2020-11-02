package com.company.codingscales.binarysearchio.concepts.LinkedList;

public class LinkedListCenter {
    static class LLNode {
        int val;
        LLNode next;
    }

    public int solve(LLNode node) {
        LLNode slow = node;
        LLNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow != null ? slow.val : -1;
    }
}
