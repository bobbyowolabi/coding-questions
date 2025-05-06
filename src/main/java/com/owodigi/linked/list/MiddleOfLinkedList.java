package com.owodigi.linked.list;

import com.owodigi.util.generic.list.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Middle of a Linked List
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: Find the middle node of a linked list.
 * SAMPLE DATA:
 * Input: 0 1 2 3 4
 * <p>
 * Output: 2
 * <p>
 * If the number of nodes is even, then return the second middle node.
 * <p>
 * Input: 0 1 2 3 4 5
 * <p>
 * Output: 3
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Two Pointer
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class MiddleOfLinkedList {

    public static int middleOfLinkedList(Node<Integer> head) {
        Node<Integer> mid = head, end = head;
        while (end != null && end.next != null) {
            mid = mid.next;
            end = end.next.next;
        }
        return mid.val;
    }

    @Test
    public void testCase1() {
        final Node input = Node.toLinkedList("0 1 2 3 4");
        final int expected = 2;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in the linked list");
    }

    @Test
    public void testCase2() {
        final Node input = Node.toLinkedList("0 1 2 3 4 5");
        final int expected = 3;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in the linked list");
    }

    @Test
    public void testCase1_singleElement() {
        final Node input = Node.toLinkedList("42");
        final int expected = 42;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in a single-node linked list");
    }

    @Test
    public void testCase2_evenLength() {
        final Node input = Node.toLinkedList("0 1 2 3 4 5");
        final int expected = 3;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in an even-length linked list");
    }

    @Test
    public void testCase3_oddLength() {
        final Node input = Node.toLinkedList("10 20 30 40 50");
        final int expected = 30;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in an odd-length linked list");
    }

    @Test
    public void testCase4_largeList() {
        final Node input = Node.toLinkedList("1 2 3 4 5 6 7 8 9 10 11");
        final int expected = 6;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in a large odd-length linked list");
    }

    @Test
    public void testCase5_minimalEvenLength() {
        final Node input = Node.toLinkedList("5 10");
        final int expected = 10;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in a two-node linked list");
    }

    @Test
    public void testCase6_minimalOddLength() {
        final Node input = Node.toLinkedList("7 14 21");
        final int expected = 14;
        final int actual = middleOfLinkedList(input);
        Assertions.assertEquals(expected, actual, "Value of the middle node in a three-node linked list");
    }
}
