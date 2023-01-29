package com.owodigi.breadth.first.search;

import com.owodigi.util.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Title: Minimum Depth of a Binary Tree (easy)
 * Status: SOLVED ✅
 * Source: <a href="https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO">...</a>
 * Problem Statement: Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the
 * shortest path from the root node to the nearest leaf node.
 * Sample Data:
 *               0
 *       ┌───────┴───────┐
 *       1               1
 *   ┌───┴───┐       ┌───┴───┐
 *   2       3       2       3
 * ┌─┴─┐   ┌─┴─┐   ┌─┴─┐   ┌─┴─┐
 * 4   5       6   4   5       6
 */
class MinimumBinaryTreeDepth {
    public static int findDepth(final TreeNode root) {
        final Queue<TreeNode> toVisit =  new ArrayDeque<>();
        toVisit.add(root);
        int depth = 0;
        while (toVisit.isEmpty() == false) {
            final int levelSize = toVisit.size();
            ++depth;
            for (int i = 0; i < levelSize; ++i) {
                final TreeNode node = toVisit.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    toVisit.add(node.left);
                }
                if (node.right != null) {
                    toVisit.add(node.right);
                }
            }
        }
        return depth;
    }


    /**
     *              12
     *       ┌───────┴───────┐
     *       7               1
     *                   ┌───┴───┐
     *                  10       5
     */
    @Test
    public void sampleData1() {
        final TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        final int expected = 2;
        final int actual = MinimumBinaryTreeDepth.findDepth(root);
        Assertions.assertEquals(expected, actual, "Tree Minimum Depth");
    }

    /**
     *              12
     *       ┌───────┴───────┐
     *       7               1
     *   ┌───┴           ┌───┴───┐
     *   9              10       5
     *                 ┌─┴
     *                11
     */
    @Test
    public void sampleData2() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        final int expected = 3;
        final int actual = MinimumBinaryTreeDepth.findDepth(root);
        Assertions.assertEquals(expected, actual, "Tree Minimum Depth");
    }
}

