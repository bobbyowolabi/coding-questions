package com.owodigi.depth.first.search.depth.first.search.iterative;

import java.util.*;

import com.owodigi.depth.first.search.depth.first.search.InorderTraversal;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * SAMPLE DATA:
 * Input: [27,10,35,5,15,null,43]
 *                     27
 *             ┌───────┴───────┐
 *             10              35
 *         ┌───┴───┐           ┴───┐
 *         5       15               43
 * Output: [5,10,15,27,35,43]
 */
public class BinaryTreeInorderTraversal extends InorderTraversal {

    private void visitLeft(Node node, final Stack<Node> stack) {
        if (node == null)
            return;
        while (node.left != null) {
            stack.push(node.left);
            node = node.left;
        }
    }

    private void inorderTraversal(final Node node, final List<Integer> result) {
        final Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (stack.isEmpty() == false) {
            visitLeft(node, stack);
            final Node current = stack.pop();
            result.add(current.data);
            visitLeft(current.right, stack);
        }
    }

    public List<Integer> inorderTraversal(Node root) {
        final List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
}
