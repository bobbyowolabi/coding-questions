package com.owodigi.depth.first.search;

import com.owodigi.util.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Maximum Path Sum
 * LEVEL: Hard 🟥
 * PROBLEM STATEMENT: Given a binary tree, find the maximum path sum from any two "alive nodes" within the tree.
 * We can assume a node is an alive node if and only if it is a leaf node, indicated by an asterisk below.
 * SAMPLE DATA:
 * Input
 *
 *              5
 *            /    \
 *          2       0
 *         /       /  \
 *       *25      *14  *15
 * Output:
 * 47 = 25 + 2 + 5 + 0 + 15
 * -------------------
 * STATUS: SOLVED ✅
 * ---------------------------------------------------------
 *                  SANDBOX
 * ---------------------------------------------------------
 * REPEAT: (Outloud) to Test Understanding
 * CLARIFICATION:
 *      * Positive / Negative Node Values
 *      * Does the solution have to go through the root (Can a subtree be a solution?)
 *      * What is the minimum path?
 *      * What are the range of Node values?
 *      * Safe to assume no node value will equal Integer.MIN_VALUE?
 * EDGE CASES & CONSTRAINTS:
 *      * Input is just a leaf node
 *      * Input is 1 node with children
 *      * Empty Tree
 * SOLUTIONS: ...
 * PATTERN: Depth First Search
 * PSEUDOCODE: (Optional) to Get Clarity of Thought
 * -------------------
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: Best Case - O(logn); Worst Case - O(n)
 */
public class MaximumPathSum {
    private static int MAX;

    static int maxPathHelper(final Node node) {
        if (node == null) {
            return 0;
        }
        final int left = maxPathHelper(node.left);
        final int right = maxPathHelper(node.right);
        final int sum = node.value + left + right;
        if (node.left != null && node.right != null) {
            MAX = Math.max(MAX, sum);
        }
        return node.value + Math.max(left, right);
    }

    static int maxPath(final Node node) {
        MAX = Integer.MIN_VALUE;
        maxPathHelper(node);
        return MAX == Integer.MIN_VALUE ? 0 : MAX;
    }

    private void test(final Node node, final int expected) {
        final int actual = maxPath(node);
        Assertions.assertEquals(expected, actual, "Maximum path sum from any two leaf nodes");
    }

    @Test
    public void test1() {
        final Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(25);
        root.right = new Node(0);
        root.right.right = new Node(15);
        root.right.left = new Node(14);
        test(root, 47);
    }

    @Test
    public void test2() {
        final Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        test(root, 6);
    }

    /**
     *                1
     *              /   \
     *            2       3
     *          /  \     / \
     *         1    3   5   6
     *                  / \  /
     *                 7   8 9
     */
    @Test
    public void test3() {
        final Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.left = new Node(9);
        test(root, 31);
    }

    @Test
    public void test4() {
        final Node root = new Node(-1);
        root.left = new Node(-3);
        test(root, 0);
    }
}
