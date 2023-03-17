package com.owodigi.breadth.first.search;

import com.owodigi.util.Assert;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class InvertBinaryTree {

    private void swapChildren(final Node node) {
        final Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public Node invertTree(final Node node) {
        if (node == null) {
            return null;
        }
        invertTree(node.left);
        invertTree(node.right);
        swapChildren(node);
        return node;
    }

    @Test
    //[4,2,7,1,3,6,9]
    public void testCase1() {
        final Node input = new Node(4);
        input.left = new Node(2);
        input.right = new Node(7);
        input.left.left = new Node(1);
        input.left.right = new Node(3);
        input.right.left = new Node(6);
        input.right.right = new Node(9);
        final Node expected = new Node(4);
        expected.left = new Node(7);
        expected.right = new Node(2);
        expected.left.left = new Node(9);
        expected.left.right = new Node(6);
        expected.right.left = new Node(3);
        expected.right.right = new Node(1);
        final Node actual = invertTree(input);
        Assert.assertEquals(expected, actual);
    }
}
