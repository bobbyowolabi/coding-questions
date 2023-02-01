package com.owodigi.stack;

import com.owodigi.util.Assert;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Flatten Binary Tree to Linked List
 * LEVEL: Medium
 * STATUS: NOT SOLVED ❌
 * PROBLEM STATEMENT: Given the root of a binary tree, flatten the tree into a linked list.  That is, using the same
 * Node class, have all the left pointers, point to NULL and all right pointers point to the next node in preorder.
 * SAMPLE DATA:
 *               1
 *       ┌───────┴───────┐
 *       2               9
 *   ┌───┴───┐       ┌───┴───┐
 *   3       4       10      11
 * ┌─┴─┐   ┌─┴─┐   ┌─┴─┐   ┌─┴─┐
 * 5   6   7   8   12  13  14  15
 */
public class FlattenTree {

    public static Node flatten(final Node node) {
        // Enter code
       return node;
    }

    /**
     * Input:
     *               1
     *       ┌───────┴───────┐
     *       2               5
     *   ┌───┴───┐           ┴───┐
     *   3       4               6
     *
     * Output:
     *   1
     *    \
     *     2
     *      \
     *       3
     *        \
     *         4
     *          \
     *           5
     *            \
     *             6
     */
    @Test
    public void testCase1() {
        final Node expected = new Node(1);
        expected.right = new Node(2);
        expected.right.right = new Node(3);
        expected.right.right.right = new Node(4);
        expected.right.right.right.right = new Node(5);
        expected.right.right.right.right.right = new Node(6);
        final Node actual = new Node(1);
        actual.left = new Node(2);
        actual.left.left = new Node(3);
        actual.left.right = new Node(4);
        actual.right = new Node(5);
        actual.right.right = new Node(6);
        FlattenTree.flatten(actual);
        Assert.assertEquals(expected, actual);
    }
}
