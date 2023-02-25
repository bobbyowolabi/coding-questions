package com.owodigi.two.pointers;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Valid Palindrome
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * SAMPLE DATA:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 */
public class Palindrome {
    public boolean isPalindrome(final String s) {
        final StringBuilder builder = new StringBuilder(s.toLowerCase());
        for (int i = 0; i < builder.length(); ++i) {
            if (!Character.isLetterOrDigit(builder.charAt(i))) {
                builder.deleteCharAt(i);
                --i;
            }
        }
        int start = 0;
        int end = builder.length() - 1;
        while (start < end) {
            if (builder.charAt(start++) != builder.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private void test(final String input, final boolean expected) {
        final boolean actual = isPalindrome(input);
        Assertions.assertEquals(expected, actual, "Is Valid Palindrome");

    }

    @Test
    public void testCase1() {
        test("A man, a plan, a canal: Panama", true);
    }

    @Test
    public void testCase2() {
        test("race a car", false);
    }

    @Test
    public void testCase3() {
        test(" ", true);
    }
}
