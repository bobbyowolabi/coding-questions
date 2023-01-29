package com.owodigi.depth.first.search;

import com.owodigi.util.Assert;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Flatten Binary Tree to Linked List
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

    private static boolean isLeaf(final Node node) {
        return node.left == null && node.right == null;
    }

    public static void flatten(final Node node) {
        if (node == null || isLeaf(node)) {
            return;
        }
        if (node.left != null) {
            flatten(node.left);
            final Node temp = node.right;
            node.right = node.left;
            node.left = null;
            Node current = node.right;
            while (current.right != null) {
                current = current.right;
            }
            current.right = temp;
        }
        flatten(node.right);
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
    public void sampleData1() {
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
