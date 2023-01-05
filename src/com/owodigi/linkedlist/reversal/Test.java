package com.owodigi.linkedlist.reversal;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        final LinkedList actual = createList(new int[]{1,-2,3,4,-5,4,3,-2,1});
        ReverseLinkedList.reverse(actual.head);
    }

    private LinkedList createList(final int[] values) {
        final LinkedList list = new LinkedList();
        list.createLinkedList(values);
        return list;
    }
}