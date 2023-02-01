package com.owodigi.depth.first.search;

import com.owodigi.util.Assert;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Invert Binary Tree
 * LEVEL: EASY
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class InvertTree{
    public static Node invertTree(final Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        final Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }

    @Test
    public void sampleData1() {
        final Node input = new Node(1);
        input.left = new Node(2);
        input.right = new Node(3);
        final Node expected = new Node(1);
        expected.left = new Node(3);
        expected.right = new Node(2);
        final Node actual = invertTree(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sampleData2() {
        final Node input = new Node(10);
        input.left = new Node(5);
        input.left.left = new Node(2);
        input.left.right = new Node(7);
        input.right = new Node(20);
        final Node expected = new Node(10);
        expected.right = new Node(5);
        expected.right.right = new Node(2);
        expected.right.left = new Node(7);
        expected.left = new Node(20);
        final Node actual = invertTree(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sampleData3() {
        final Node input = new Node(100);
        input.left = new Node(50);
        input.left.left = new Node(25);
        input.left.right = new Node(75);
        input.right = new Node(200);
        input.right.right = new Node(350);
        final Node expected = new Node(100);
        expected.right = new Node(50);
        expected.right.right = new Node(25);
        expected.right.left = new Node(75);
        expected.left = new Node(200);
        expected.left.left = new Node(350);
        final Node actual = invertTree(input);
        Assert.assertEquals(expected, actual);
    }
}
