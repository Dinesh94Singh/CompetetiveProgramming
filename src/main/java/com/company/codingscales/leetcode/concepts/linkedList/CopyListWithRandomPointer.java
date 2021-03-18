package com.company.codingscales.leetcode.concepts.linkedList;

import java.util.*;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(final int val) {
            this.val = val;
        }
    }

    public Node copyRandomListWithHashMap(final Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.putIfAbsent(curr, new Node(curr.val));
            Node clone = map.get(curr);

            if (curr.next != null) {
                map.putIfAbsent(curr.next, new Node(curr.next.val));
                clone.next = map.get(curr.next);
            }
            if (curr.random != null) {
                map.putIfAbsent(curr.random, new Node(curr.random.val));
                clone.random = map.get(curr.random);
            }
            curr = curr.next;
        }

        return map.get(head);
    }

    public Node copyRandomList(final Node head) {


        if (head == null)
            return null;
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            Node next = curr.next;

            curr.next = clone;
            clone.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random != null)
                curr.next.random = random.next;
            curr = curr.next.next;
        }

        // remove the interleaving
        Node newHead = head.next;
        curr = head;

        while (curr != null) {

            Node clone = curr.next;
            Node next = clone.next;

            curr.next = next;
            if (next != null)
                clone.next = next.next;

            curr = curr.next;
        }

        return newHead;
    }
}
