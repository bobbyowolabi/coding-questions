package com.owodigi.string;

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
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(final String s) {
        int maximum = 0;
        final Set<Character> seen = new HashSet<>();
        int start = 0, end = 0;
//        for (int end = 0;) {
//
//        }
        while(end < s.length()) {
            final char c = s.charAt(end++);
            if (seen.contains(c)) {
                final int length = end - start;
                maximum = Math.max(length, maximum);
                ++start;
                seen.remove(c); //
            } else {
                seen.add(c);
            }
        }
        return maximum;
    }

    private void test(final String s, final int expected) {
        final int actual = lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, actual, "Length of Longest String");
    }

    @Test
    public void testCase1() {
        test("abcabcbb", 3);
    }

    @Test
    public void testCase2() {
        test("bbbbb", 1);
    }

    @Test
    public void testCase3() {
        test("pwwkew", 3);
    }

    @Test
    public void testCase4() {
        test("aab", 2);
    }
}
