package com.company.codingscales.interviews.facebook;

public class ReverseOdds {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
        }
    }

    Node reverseOdds(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.data % 2 == 0) {
            Node t = curr.next;
            curr.next = prev;

            prev = curr;
            curr = t;
        }

        head.next = curr;
        return prev;
    }

    Node reverse(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                prev.next = reverseOdds(curr);
            }

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
