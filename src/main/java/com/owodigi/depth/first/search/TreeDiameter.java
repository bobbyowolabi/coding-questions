package com.owodigi.depth.first.search;

import com.owodigi.util.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Diameter of Binary Tree
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given the root of a binary tree, return the length of the diameter of the tree.  The diameter of
 * a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass
 * through the root.  The length of a path between two nodes is represented by the number of edges between them.
 * SAMPLE DATA:
 *               1
 *       ┌───────┴───────┐
 *       2               9
 *   ┌───┴───┐       ┌───┴───┐
 *   3       4       10      11
 * ┌─┴─┐   ┌─┴─┐   ┌─┴─┐   ┌─┴─┐
 * 5   6   7   8   12  13  14  15
 */
class TreeDiameter {
    private int max;

    private int height(final TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int diameter(final TreeNode node) {
        if (node == null) {
            return 0;
        }
        final int leftHeight = height(node.left);
        final int rightHeight = height(node.right);
        final int diameter = leftHeight + rightHeight;
        max = Math.max(max, diameter);
        diameter(node.left);
        diameter(node.right);
        return max;
    }

    public int diameterOfBinaryTree(final TreeNode node) {
        max = 0;
        diameter(node);
        return max;
    }

    /**
     * Input:
     *               1
     *       ┌───────┴───────┐
     *       2               3
     *   ┌───┴           ┌───┴───┐
     *   4               5       6
     */
    @Test
    public void testCase1() {
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.left.left = new TreeNode(4);
        input.right.left = new TreeNode(5);
        input.right.right = new TreeNode(6);
        final int expected = 4;
        final int actual = new TreeDiameter().diameterOfBinaryTree(input);
        Assertions.assertEquals(expected, actual, "diameter of binary tree");
    }

    /**
     *               1
     *       ┌───────┴───────┐
     */
    @Test
    public void testCase2() {
        TreeNode input = new TreeNode(1);
        final int expected = 0;
        final int actual = new TreeDiameter().diameterOfBinaryTree(input);
        Assertions.assertEquals(expected, actual, "diameter of binary tree");
    }

    /**
     * Input:
     *               1
     *       ┌───────┴───────┐
     *       2               3
     *                   ┌───┴───┐
     *                   4       5
     *                 ┌─┴       ┴─┐
     *                 6           7
     *               ┌─┴           ┴─┐
     *               8               9
     */
    @Test
    public void testCase3() {
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.right.left = new TreeNode(4);
        input.right.left.left = new TreeNode(6);
        input.right.left.left.left = new TreeNode(8);
        input.right.right = new TreeNode(5);
        input.right.right.right = new TreeNode(7);
        input.right.right.right.right = new TreeNode(9);
        final int expected = 6;
        final int actual = new TreeDiameter().diameterOfBinaryTree(input);
        Assertions.assertEquals(expected, actual, "diameter of binary tree");
    }
}
