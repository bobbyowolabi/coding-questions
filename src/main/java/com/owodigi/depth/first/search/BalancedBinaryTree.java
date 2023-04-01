package com.owodigi.depth.first.search;

import java.util.*;

import com.owodigi.util.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Balanced Binary Tree
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: A balanced binary tree is one where the height of the left and right subtrees of every node differs by a max of 1.  Given the root of a tree, determine if it is balanced.
 * SAMPLE DATA:
 */
public class BalancedBinaryTree {

    private int height(final TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        final int leftHeight = height(root.left);
        final int rightHeight = height(root.right);
        return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    @Test
    public void testCase1() {
    }
}
