package com.owodigi.breadth.first.search;

import java.util.*;

import com.owodigi.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Word Ladder
 * LEVEL: Hard 🟥
 * PROBLEM STATEMENT: Given two words, startWord and endWord, and a dictionary of words, find the length of the shortest
 * transformation sequence from startWord to endWord. A transformation sequence involves changing one letter at a time,
 * where each intermediate word must exist in the given dictionary, and each transformed word must be a valid word.
 *
 * Write a function shortestWordLadder(startWord, endWord, wordDict) that returns the length of the shortest
 * transformation sequence, or 0 if no such sequence exists.
 * SAMPLE DATA:
 * startWord = "hit"
 * endWord = "cog"
 * wordDict = ["hot", "dot", "dog", "lot", "log", "cog"]
 *
 * Output:
 * 5
 * -------------------
 * STATUS: SOLVED ✅
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class WordLadder {
    private boolean differsByOne(final String a, final String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public int ladderLength(final String beginWord, final String endWord, final List<String> wordList) {
        final Map<String, List<String>> graph = new HashMap<>();
        for (final String word : wordList) {
            graph.put(word, new ArrayList<>());
        }
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            final String word = entry.getKey();
            final List<String> edges = entry.getValue();
            for (final String candidate : wordList) {
                if (differsByOne(word, candidate)) {
                    edges.add(candidate);
                }
            }
        }
        final Queue<String> toVisit = new ArrayDeque<>();
        final Set<String> visited = new HashSet<>();
        for (final String word : graph.keySet()) {
            if (differsByOne(beginWord, word)) {
                toVisit.add(word);
            }
        }
        int length = 1;
        final List<String> edges = new ArrayList<>();
        while (toVisit.isEmpty() == false) {
            ++length;
            for (final String next : toVisit) {
                if (visited.contains(next)) {
                    continue;
                } else {
                    visited.add(next);
                }
                if (next.equals(endWord)) {
                    return length;
                }
                final List<String> nextEdges = graph.get(next);
                if (nextEdges != null) {
                    edges.addAll(nextEdges);
                }
            }
            toVisit.clear();
            toVisit.addAll(edges);
            edges.clear();
        }
        return 0;
    }

    private void test(final String beginWord, final String endWord, final List<String> wordList, final int expected) {
        final int actual = ladderLength(beginWord, endWord, wordList);
        Assertions.assertEquals(expected, actual, "length of the shortest transformation sequence");
    }

    @Test
    public void testCase1() {
        final String beginWord = "hit";
        final String endWord = "cog";
        final List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        final int expected = 5;
        test(beginWord, endWord, wordList, expected);
    }

    @Test
    public void testCase2() {
        final String beginWord = "hit";
        final String endWord = "cog";
        final List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        final int expected = 0;
        test(beginWord, endWord, wordList, expected);
    }
}
