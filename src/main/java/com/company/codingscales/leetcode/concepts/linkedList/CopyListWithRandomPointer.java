package com.company.codingscales.leetcode.concepts.linkedList;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(final int val) {
            this.val = val;
        }
    }
    public Node copyRandomList(final Node head) {
        if (head == null)
            return null;
        Node p1 = head;

        while (p1 != null) {
            Node t = new Node(p1.val);
            Node dummy = p1.next;

            p1.next = t;
            t.next = dummy;

            p1 = dummy;
        }


        p1 = head;
        while (p1 != null) {
            p1.next.random = p1.random != null ? p1.random.next : null;
            p1 = p1.next.next;
        }

        p1 = head;
        Node p2 = head.next;

        Node ret = p1.next;

        while (p1 != null) {
            p1.next = p1.next.next;
            p2.next = p2.next != null ? p2.next.next : null;

            p2 = p2.next;
            p1 = p1.next;
        }

        return ret;
    }
}
