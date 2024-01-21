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
        int result = 0;
        final Set<Character> dictionary = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            final char next = s.charAt(i);
            final boolean seen = dictionary.contains(next);
            final boolean repeat = i > 0 ? s.charAt(i) == s.charAt(i - 1) : false;
            if (seen) {
                result = Math.max(dictionary.size(), result);
                dictionary.clear();
            } else {
                dictionary.add(next);
            }
        }
        result = Math.max(dictionary.size(), result);
        return result;
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
