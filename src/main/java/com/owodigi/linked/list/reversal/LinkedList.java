package com.owodigi.linked.list.reversal;

// Template for the linked list
class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a com.owodigi.linkedlist.reversal.LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a com.owodigi.linkedlist.reversal.LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }


}