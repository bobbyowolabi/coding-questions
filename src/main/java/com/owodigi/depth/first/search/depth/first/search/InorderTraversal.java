package com.owodigi.depth.first.search.depth.first.search;

import java.util.*;

import com.owodigi.util.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public abstract class InorderTraversal {

    public abstract List<Integer> inorderTraversal(TreeNode root);

    @Test
    public void testCase1() {
        final TreeNode input = new TreeNode(1);
        input.right = new TreeNode(2);
        input.right.left = new TreeNode(3);
        final List<Integer> expected = Arrays.asList(1,3,2);
        final List<Integer> actual = inorderTraversal(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        final TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        final List<Integer> expected = Arrays.asList(2,1);
        final List<Integer> actual = inorderTraversal(input);
        Assertions.assertEquals(expected, actual);
    }
}
