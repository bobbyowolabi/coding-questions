package com.owodigi.depth.first.search;

import com.owodigi.util.Assert;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Maximum Depth of Binary Tree
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given a binary tree's root, return it's maximum depth; that is, the longest path starting at the root.
 * SAMPLE DATA:
 */
public class MaxDepth {

    public static int maxDepth(final Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1 ;
    }

    @Test
    public void sampleData1() {
        final Node input = new Node(1);
        input.left = new Node(2);
        input.right = new Node(3);
        final int expected = 2;
        final int actual = maxDepth(input);
        Assertions.assertEquals(expected, actual, "max depth starting from root");
    }

    @Test
    public void sampleData2() {
        final Node input = new Node(3);
        input.left = new Node(9);
        input.right = new Node(10);
        input.right.left = new Node(5);
        input.right.right = new Node(6);
        final int expected = 3;
        final int actual = maxDepth(input);
        Assertions.assertEquals(expected, actual, "max depth starting from root");
    }

    @Test
    public void sampleData3() {
        final Node input = new Node(3);
        input.right = new Node(9);
        final int expected = 2;
        final int actual = maxDepth(input);
        Assertions.assertEquals(expected, actual, "max depth starting from root");
    }

    @Test
    public void sampleData4() {
        final Node input = new Node(3);
        final int expected = 1;
        final int actual = maxDepth(input);
        Assertions.assertEquals(expected, actual, "max depth starting from root");
    }

    @Test
    public void sampleData5() {
        final Node input = new Node(1);
        input.right = new Node(2);
        input.right.right = new Node(3);
        input.right.right.right = new Node(4);
        input.right.right.right.right = new Node(5);
        input.right.right.right.right.right = new Node(6);
        final int expected = 6;
        final int actual = maxDepth(input);
        Assertions.assertEquals(expected, actual, "max depth starting from root");
    }
}
