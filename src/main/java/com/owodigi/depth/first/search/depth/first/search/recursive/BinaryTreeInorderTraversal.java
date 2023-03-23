package com.owodigi.depth.first.search.depth.first.search.recursive;

import java.util.*;

import com.owodigi.depth.first.search.depth.first.search.InorderTraversal;
import com.owodigi.util.Assert;
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
public class BinaryTreeInorderTraversal extends InorderTraversal {


    private void inorderTraversal(final Node node, final List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, result);
        result.add(node.data);
        inorderTraversal(node.right, result);
    }

    public List<Integer> inorderTraversal(Node root) {
        final List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
}
