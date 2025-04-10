package com.owodigi.sliding.window;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Longest Substring without Repeating Characters
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Find the length of the longest substring of a given string without repeating characters.
 * SAMPLE DATA:
 * Input: abccabcabcc
 *
 * Output: 3
 *
 * Explanation: The longest substrings are abc and cab, both of length 3.
 *
 * Input: aaaabaaa
 *
 * Output: 2
 *
 * Explanation: ab is the longest substring, with a length of 2
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Sliding Window
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class LongestSubstringNoRepeatingCharacters {

    public static int longestSubstringWithoutRepeatingCharacters(final String s) {
        int left = 0, longest = 0;
        final Map<Character, Integer> seen = new HashMap<>();
        for (int right = 0; right < s.length(); ++right) {
            final char next = s.charAt(right);
            if (seen.containsKey(next)) {
                left = Math.max(left, seen.get(next) + 1);
            }
            seen.put(next, right);
            final int currentLength = right - left + 1;
            longest = Math.max(longest, currentLength);
        }
        return longest;
    }

    private void test(final String input, final int expected) {
        final int actual = longestSubstringWithoutRepeatingCharacters(input);
        Assertions.assertEquals(expected, actual, "length of the longest substring without repeating characters");
    }

    @Test
    public void testCase1() {
        test("abcdbea", 5);
    }

    @Test
    public void testCase2() {
        test("aba", 2);
    }

    @Test
    public void testCase3() {
        test("abccabcabcc", 3);
    }

    @Test
    public void testCase4() {
        test("aaaabaaa", 2);
    }
}
