package com.owodigi.hash.table;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class ValidAnagram {

    private void increment(final Character c, final Map<Character, Integer> frequencies) {
        Integer frequency = frequencies.get(c);
        if (frequency == null) {
            frequency = 1;
        } else {
            ++frequency;
        }
        frequencies.put(c, frequency);
    }

    private boolean decrement(final Character c, final Map<Character, Integer> frequencies) {
        Integer frequency = frequencies.get(c);
        if (frequency == null) {
            return false;
        } else {
            --frequency;
        }
        frequencies.put(c, frequency);
        return true;
    }

    private boolean allZero(final Map<Character, Integer> frequencies) {
        for (final Integer frequency : frequencies.values()) {
            if (frequency != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            final char next = s.charAt(i);
            increment(next, frequencies);
        }
        for (int i = 0; i < t.length(); ++i) {
            final char next = t.charAt(i);
            if (decrement(next, frequencies) == false) {
                return false;
            }
        }
        return allZero(frequencies);
    }

    @Test
    public void testCase1() {
        final String a = "anagram";
        final String b = "nagaram";
        final boolean expected = true;
        final boolean actual = isAnagram(a, b);
        Assertions.assertEquals(expected, actual, "Is Valid Anagram?");
    }
}
