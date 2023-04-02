package com.owodigi.string;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Longest Common Prefix
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * SAMPLE DATA:
 *      Input:      ["flower","flow","flight"]
 *      Expected: " fl"
 * -------------------
 * STATUS: SOLVED ✅
 * RUNTIME COMPLEXITY: O(nlogn) + O(m) = O(nlogn)  - (where m = the length of the shortest word)
 * SPACE COMPLEXITY: O(1)
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        final String first = strs[0];
        final String last = strs[strs.length - 1];
        final int length = Math.min(first.length(), last.length());
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            if (first.charAt(i) == last.charAt(i)) {
                result.append(first.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    private void test(final String[] input, final String expected) {
        final String actual = longestCommonPrefix(input);
        Assertions.assertEquals(expected, actual, "Longest Common Prefix");
    }

    @Test
    public void testCase1() {
        final String[] input = {"flower", "flow", "flight"};
        final String expected = "fl";
        test(input, expected);
    }

    @Test
    public void testCase2() {
        final String[] input = {"dog", "racecar", "car"};
        final String expected = "";
        test(input, expected);
    }
}