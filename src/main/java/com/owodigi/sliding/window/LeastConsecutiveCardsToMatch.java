package com.owodigi.sliding.window;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Least Consecutive Cards to Match
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Given a list of integers cards, your goal is to match a pair of cards, but you can only pick
 * up cards in a consecutive manner. What's the minimum number of cards that you need to pick up to make a pair?
 * If there are no matching pairs, return -1.
 *
 * SAMPLE DATA:
 * cards = [3, 4, 2, 3, 4, 7]
 *
 * picking up [3, 4, 2, 3] makes a pair of 3s
 * picking up [4, 2, 3, 4] matches two 4s.
 *
 * Output = 4
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Sliding Window
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class LeastConsecutiveCardsToMatch {

    public static int leastConsecutiveCardsToMatch(List<Integer> cards) {
        int left = 0, min = Integer.MAX_VALUE;
        final Set<Integer> seen = new HashSet<>();
        for (int right = 0; right < cards.size(); ++right) {
            final int next = cards.get(right);
            if (seen.contains(next)) {
                while (seen.contains(next)) {
                    min = Math.min(min, right - left + 1);
                    seen.remove(cards.get(left));
                    ++left;
                }
            } else {
                seen.add(next);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void test(final List<Integer> input, final int expected) {
        final int actual = leastConsecutiveCardsToMatch(input);
        Assertions.assertEquals(expected, actual, "minimum number of cards that you need to pick up to make a pair");
    }

    @Test
    public void testCase1() {
        test(List.of(3, 4, 2, 3, 4, 7), 4);
    }

    @Test
    public void testCase2() {
        test(List.of(1, 0, 5, 3), -1);
    }

    @Test
    public void testCase3() {
        test(List.of(5), -1);
    }

    @Test
    public void testCase4() {
        test(List.of(7, 7), 2);
    }
}
