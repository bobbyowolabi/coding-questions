package com.owodigi.depth.first.search.recursive;

import java.util.*;

import com.owodigi.depth.first.search.InorderTraversal;
import com.owodigi.util.TreeNode;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class BinaryTreeInorderTraversal extends InorderTraversal {


    private void inorderTraversal(final TreeNode node, final List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
}
