package com.company.codingscales.leetcode.concepts.linkedList;

public class FlattenAMultiLevelDoubleLinkedList {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;
        Node() {

        }
    }

    Node auxHead = null;
    Node tail = null;
    public Node flatten(Node head) {
        dfs(head);
        return auxHead;
    }

    private void dfs(Node curr) {
        if (curr == null)
            return;

        Node nxt = curr.next;

        if (auxHead == null) {
            auxHead = curr;
            tail = curr;
        } else {
            tail.next = curr;
            curr.prev = tail;

            tail = curr;
        }

        if (curr.child != null) {
            dfs(curr.child);
            curr.child = null;
        }

        if (nxt != null) {
            dfs(nxt);
        }
    }
}
