package com.owodigi.graph;

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
public class ShortestPath {

    private static List<Integer> getNeighbors(final List<List<Integer>> graph, final int node) {
        return graph.get(node);
    }

    public static int shortestPath(final List<List<Integer>> graph, final int a, final int b) {
        final Queue<Integer> toVisit = new ArrayDeque<>();
        final Set<Integer> visited = new HashSet<>();
        int edgeCount = 0;
        toVisit.add(a);
        while (!toVisit.isEmpty()) {
            final int nodeCount = toVisit.size();
            for (int i = 0; i < nodeCount; ++i) {
                final Integer node = toVisit.poll();
                if (node == b) {
                    return edgeCount;
                }
                for (final int neighbor : getNeighbors(graph, node)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    visited.add(neighbor);
                    toVisit.add(neighbor);
                }
            }
            ++edgeCount;
        }
        return 0;
    }

    @Test
    public void testCase1_directConnection() {
        // 0 -- 1
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),    // neighbors of 0
                Arrays.asList(0)     // neighbors of 1
        );
        Assertions.assertEquals(1, shortestPath(graph, 0, 1));
    }

    @Test
    public void testCase2_indirectConnection() {
        // 0 -- 1 -- 2
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),        // 0
                Arrays.asList(0, 2),     // 1
                Arrays.asList(1)         // 2
        );
        Assertions.assertEquals(2, shortestPath(graph, 0, 2));
    }

    @Test
    public void testCase3_sameNode() {
        // trivial case
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0)
        );
        Assertions.assertEquals(0, shortestPath(graph, 0, 0));
    }

    @Test
    public void testCase4_disconnectedNodes() {
        // 0 -- 1    2 (no connection)
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),    // 0
                Arrays.asList(0),    // 1
                Arrays.asList()      // 2
        );
        Assertions.assertEquals(0, shortestPath(graph, 0, 2));
    }

    @Test
    public void testCase5_cycleGraph() {
        // 0 -- 1 -- 2
        // |         |
        // 4 -- 3 ----
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 4),       // 0
                Arrays.asList(0, 2),       // 1
                Arrays.asList(1, 3),       // 2
                Arrays.asList(2, 4),       // 3
                Arrays.asList(0, 3)        // 4
        );
        Assertions.assertEquals(2, shortestPath(graph, 0, 2));
    }

    @Test
    public void testCase6_largeGraph() {
        // Line graph: 0 - 1 - 2 - 3 - 4 - 5
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),        // 0
                Arrays.asList(0, 2),     // 1
                Arrays.asList(1, 3),     // 2
                Arrays.asList(2, 4),     // 3
                Arrays.asList(3, 5),     // 4
                Arrays.asList(4)         // 5
        );
        Assertions.assertEquals(5, shortestPath(graph, 0, 5));
    }
}
