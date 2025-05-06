package com.owodigi;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL: Easy 🟩 | Medium 🟨 | Hard 🟥
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
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
public class NeedToORganize {
    /*
     * Click `Run` to execute the snippet below!
     */

//import java.io.*;
//import java.util.*;

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

    class Solution {
        public static void main(String[] args) {
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("Hello, World!");
            strings.add("Welcome to CoderPad.");
            strings.add("This pad is running Java " + Runtime.version().feature());

            for (String string : strings) {
                System.out.println(string);
            }
        }
    }


// Your previous Plain Text content is preserved below:

// Welcome to Meta!

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you would like to use for your interview,
// simply choose it from the dropdown in the left bar.

// Enjoy your interview!

//    Imagine an array that contains both integers and nested arrays, such as the following: [8, 4, [5, [9], 3], 6]. The depth sum is described as the weighted sum of each integer, weighted by their respective depths. In the example, 8's depth is 1, while 9's is 3.
//    Output: 8 + 4 + 2 * 5 + 3 * 9 + 2 * 3 + 6 = 61

// negatives fine
// empty arrays fine,
// array could be null

    //[8, 4, [5, [9], 3], 6]
//t0 - sum = 8; element = 8,
//t1 - sum = 12; element = 4,
//t2 - sum = 12 + depthSum([5, [9], 3], 2); element = [5, [9], 3],
//t3 - sum = 10; element = 5
//t4 - sum = 10; element = [9]
//    public int depthSum(NestedArray arr, final int level) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; ++i) {
//            final NestArrayElement element = arr.get(i);
//            if (element.isInteger()) {
//                sum += element.value * level;
//            } else {
//                sum += depthSum(element.array, level + 1);
//            }
//        }
//        return sum;
//    }
//
//    public int depthSum(NestedArray arr) {
//        return depthSum(arr, 1);
//    }
//
//
//    Given a binary tree (pointer to the root), a target node anywhere in the tree,
//    and an integer value K. Return a list of the values of all the nodes that have
//    a distance K from the target node. The order of the list does not matter.
//
//            >>>find_at_distance(root, targetNode, 2)
//[2, 6, 7, 8]
//
//            5
//            / \
//            8  (3)
//            /   / \
//            1   9   4
//            / \   \
//            2   6   7

    //t0 - toVisit=[3]; level=0; nextLevel=[9,4]; result=[]; k=2
//t1 - toVisit=[1, 9, 4]; level=1; nextLevel=[1, 9, 4]; result=[];k=2
//t0 - toVisit=[1, 9, 4]; level=2; nextLevel=[]; result=[];k=2
//    public List<Integer> find_at_distance(final Node root, final Node targetNode, final int k) {
//        Queue<Node> toVisit = new ArrayDeque<>();
//        toVisit.add(targetNode);
//        int level = 0;
//        List<Integer> result = new ArrayList<>();
//
//        while(!toVisit.isEmpty()) {
//            List<Node> nextLevel = new ArrayList<>();
//            for (final Node current : toVisit) {
//                if (level == k) {
//                    result.add(current.value);
//                }
//                if (next.left != null) {
//                    nextLevel.add(current.left);
//                }
//                if (next.right != null) {
//                    nextLevel.add(current.right);
//                }
//            }
//            toVisit.clear();
//            toVisit.addAll(nextLevel);
//            ++level;
//        }
//        return result;
//    }


    @Test
    public void testCase1() {
    }
}
