package com.owodigi.linkedlist.reversal;

public class ReverseLinkedList {
    public static LinkedListNode reverse(final LinkedListNode originalHead) {
        if (originalHead == null || originalHead.next == null) {
            return originalHead;
        }
        LinkedListNode next = originalHead.next;
        LinkedListNode head = originalHead;
        head.next = null;
        while (next != null) {
            LinkedListNode current = next;
            next = next.next;
            current.next = head;
            head = current;
        }
        return head;
    }
}

// 1 -> 2 -> 3 -> NULL