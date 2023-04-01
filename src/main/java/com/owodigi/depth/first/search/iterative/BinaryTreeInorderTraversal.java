package com.owodigi.depth.first.search.iterative;

import java.util.*;

import com.owodigi.depth.first.search.InorderTraversal;
import com.owodigi.util.TreeNode;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT: Given the root of a binary tree, return the inorder traversal of its TreeNodes' values.
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

    private void visitLeft(TreeNode TreeNode, final Stack<TreeNode> stack) {
        while (TreeNode.left != null) {
            stack.push(TreeNode.left);
            TreeNode = TreeNode.left;
        }
    }

    private void inorderTraversal(final TreeNode TreeNode, final List<Integer> result) {
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(TreeNode);
        visitLeft(TreeNode, stack);
        while (stack.isEmpty() == false) {
            final TreeNode next = stack.pop();
            result.add(next.val);
            if (next.right != null) {
                stack.add(next.right);
                visitLeft(next.right, stack);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if (root != null) {
            inorderTraversal(root, result);
        }
        return result;
    }
}
