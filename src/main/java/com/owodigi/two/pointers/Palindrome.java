package com.owodigi.two.pointers;

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
public abstract class Palindrome {
    public abstract boolean isPalindrome(final String s);

    private void test(final String input, final boolean expected) {
        final boolean actual = isPalindrome(input);
        Assertions.assertEquals(expected, actual, "Is '%s' a valid palindrome?".formatted(input));
    }

    @Test
    public void testCase0a() {
        test("A man, a plan, a canal: Panama", true);
    }

    @Test
    public void testCase0() {
        test("race a car", false);
    }

    @Test
    public void testCase1() {
        test(" ", true);
    }

    @Test
    public void testCase2() {
        test("racecar", true); // Simple palindrome
    }

    @Test
    public void testCase3() {
        test("hello", false); // Not a palindrome
    }

    @Test
    public void testCase4() {
        test("Was it a car or a cat I saw?", true); // Sentence with spaces and punctuation
    }

    @Test
    public void testCase5() {
        test("No 'x' in Nixon", true); // Palindrome with apostrophe
    }

    @Test
    public void testCase6() {
        test("12321", true); // Numeric palindrome
    }

    @Test
    public void testCase7() {
        test("12345", false); // Not a palindrome (numbers)
    }

    @Test
    public void testCase8() {
        test(" ", true); // Single space is a palindrome
    }

    @Test
    public void testCase9() {
        test("", true); // Empty string is a palindrome
    }

    @Test
    public void testCase10() {
        test("Able was I, I saw Elba!", true); // Complex case with punctuation and mixed casing
    }

    @Test
    public void testCase11() {
        test("Madam In Eden, I’m Adam", true); // Famous palindrome phrase
    }

    @Test
    public void testCase12() {
        test("Palindrome", false); // A completely non-palindromic word
    }

    @Test
    public void testCase13() {
        test("!!", true); // Special characters only
    }

    @Test
    public void testCase14() {
        test("12 21", true); // Numbers with spaces
    }

    @Test
    public void testCase15() {
        test("0P", false); // Edge case: Alphanumeric with mixed case
    }
}
