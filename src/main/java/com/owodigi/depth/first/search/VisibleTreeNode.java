package com.owodigi.depth.first.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: In a binary tree, a node is labeled as "visible" if, on the path from the root to that node,
 * there isn't any node with a value higher than this node's value.
 * The root is always "visible" since there are no other nodes between the root and itself. Given a binary tree,
 * count the number of "visible" nodes.
 * SAMPLE DATA:
 *
 * -------------------
 * STATUS: SOLVED ✅ | NOT SOLVED ❌ | PARTIALLY SOLVED ☑️
 * ---------------------------------------------------------
 * SANDBOX
 * ---------------------------------------------------------
 * REPEAT: (Outloud) to Test Understanding
 * CLARIFICATION: ...
 * EDGE CASES & CONSTRAINTS: ...
 * SOLUTIONS: ...
 * PATTERN: Binary Search | Two Pointers | Sliding Window | DFS | BFS ...
 * PSEUDOCODE (Optional):
 * -------------------
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class VisibleTreeNode {

    private static int visibleTreeNode(final Node<Integer> node, int max) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (node.val >= max) {
            ++result;
        }
        max = Math.max(max, node.val);
        result += visibleTreeNode(node.left, max);
        result += visibleTreeNode(node.right, max);
        return result;
    }

    public static int visibleTreeNode(Node<Integer> root) {
        return visibleTreeNode(root, Integer.MIN_VALUE);
    }

    @Test
    public void testCase1() {
    }
}
