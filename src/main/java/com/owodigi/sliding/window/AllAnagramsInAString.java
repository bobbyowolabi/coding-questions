package com.owodigi.sliding.window;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Find All Anagrams in a String
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Given a string original and a string check, find the starting index of all substrings of
 * original that is an anagram of check. The output must be sorted in ascending order.
 *
 * SAMPLE DATA:
 *
 *
 * -------------------
 *
 * STATUS: SOLVED ✅ | NOT SOLVED ❌ | PARTIALLY SOLVED ☑️
 * PATTERN: Sliding Window
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class AllAnagramsInAString {

    private void add(final char a, final Map<Character, Integer> frequencies) {
        Integer frequency = frequencies.get(a);
        if (frequency == null) {
            frequency = 0;
        }
        frequencies.put(a, ++frequency);
    }

    private void remove(final char a, final Map<Character, Integer> frequencies) {
        Integer frequency = frequencies.get(a);
        if (frequency != null) {
            frequencies.put(a, --frequency);
            if (frequency == 0) {
                frequencies.remove(a);
            }
        }
    }

    public List<Integer> findAllAnagrams(final String original, final String check) {
        int left = 0, right = 0;
        final Map<Character, Integer> windowFrequnecy = new HashMap<>(), checkFrequency = new HashMap<>();
        final List<Integer> result = new ArrayList<>();
        while (right < original.length()) {
            if (right < check.length()) {
                add(original.charAt(right), windowFrequnecy);
                add(check.charAt(right), checkFrequency);
                ++ right;
            } else {
                if (windowFrequnecy.equals(checkFrequency)) {
                    result.add(left);
                }
                remove(original.charAt(left++), windowFrequnecy);
                add(original.charAt(right++), windowFrequnecy);
            }
        }
        if (windowFrequnecy.equals(checkFrequency)) {
            result.add(left);
        }
        return result;
    }

    private void test(final String original, final String check, final List<Integer> expected) {
        final List<Integer> actual = findAllAnagrams(original, check);
        Assertions.assertEquals(expected, actual, "Indicies of all substrings of original that are anagrams of check");
    }

    @Test
    public void testCase1() {
        test("cbaebabacd", "abc", List.of(0, 6));
    }

    @Test
    public void testCase2() {
        test("abab", "ab", List.of(0, 1, 2));
    }

    @Test
    public void testCase3() {
        test("afdgzyxksldfm", "dfg", List.of(1));
    }

    @Test
    public void testCase4() {
        test("aaabbb", "ab", List.of(2));
    }

    @Test
    public void testCase5() {
        test("abc", "abcd", List.of(0)); // check pattern longer than text
    }

    @Test
    public void testCase6() {
        test("aaa", "a", List.of(0, 1, 2)); // single repeated character
    }

    @Test
    public void testCase7() {
        test("abcdabc", "bca", List.of(0, 4)); // multiple anagrams
    }

    @Test
    public void testCase8() {
        test("a", "a", List.of(0)); // exact match, smallest size
    }

    @Test
    public void testCase9() {
        test("baa", "ab", List.of(0)); // adjacent characters swapped
    }

    @Test
    public void testCase10() {
        test("aaaaaaaaaa", "aa", List.of(0,1,2,3,4,5,6,7,8)); // lots of overlapping
    }
}
