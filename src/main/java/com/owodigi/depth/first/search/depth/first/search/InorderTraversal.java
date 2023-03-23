package com.owodigi.depth.first.search.depth.first.search;

import java.util.*;

import com.owodigi.util.Node;
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

    public abstract List<Integer> inorderTraversal(Node root);

    @Test
    public void testCase1() {
        final Node input = new Node(1);
        input.right = new Node(2);
        input.right.left = new Node(3);
        final List<Integer> expected = Arrays.asList(1,3,2);
        final List<Integer> actual = inorderTraversal(input);
        Assertions.assertEquals(expected, actual);
    }
}
