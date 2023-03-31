package com.owodigi.com.owodigi.binary.search.trees;

import java.util.*;

import com.owodigi.util.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Lowest Common Ancestor of a Binary Search Tree
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * SAMPLE DATA:
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final int max = Math.max(p.val, q.val);
        final int min = Math.min(p.val, q.val);
        if (min > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            if (max < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
    }

    @Test
    public void testCase1() {

    }
}
