package com.owodigi;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Implement a Spell Checker Using a Trie
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: You are given a dictionary of words and a string. Implement a spell checker that suggests corrections for the misspelled words in the string. The spell checker should use a trie to efficiently search for words in the dictionary.
 * Your solution should implement a SpellChecker class with the following methods:
 *  constructor(words: string[]) - Initializes the spell checker with a dictionary of words.
 *  check(word: string): string - Checks if the specified word is spelled correctly. If it is, returns the word. If it is not, returns the first suggestion found in the dictionary.
 *  suggest(word: string): string[] - Returns a list of suggestions for the specified misspelled word. Suggestions should be sorted by the number of characters that match the misspelled word.
 * SAMPLE DATA:
 *  String[] dictionary = ["hello", "world", "goodbye", "moon", "sun"];
 *  SpellChecker spellChecker = new SpellChecker(dictionary);
 *  spellChecker.check("helo") // "hello"
 * -------------------
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class SpellChecker {

    public SpellChecker(final String[] dictionary) {
        throw new UnsupportedOperationException("Implement Me!");
    }

    public String check(final String word) {
        throw new UnsupportedOperationException("Implement Me!");
    }

    public String[] suggest(final String word) {
        throw new UnsupportedOperationException("Implement Me!");
    }
}

class TestSuite {
    private static final String[] DICTIONARY = {"hello", "world", "goodbye", "moon", "sun"};
    private static final SpellChecker SPELL_CHECKER = new SpellChecker(DICTIONARY);

    private void checkTest(final String input, final String expected) {
        final String actual = SPELL_CHECKER.check(input);
        Assertions.assertEquals(expected, actual, "Return correctly spelled word or first suggestion");
    }

    @Test
    public void testCase1() {
        final String input = "helo";
        final String expected = "hello";
        checkTest(input, expected);
    }

    @Test
    public void testCase2() {
        final String input = "wrold";
        final String expected = "world";
        checkTest(input, expected);
    }

    @Test
    public void testCase3() {
        final String input = "goodbyee";
        final String expected = "goodbye";
        checkTest(input, expected);
    }

    @Test
    public void testCase4() {
        final String input = "mooon";
        final String expected = "moon";
        checkTest(input, expected);
    }

    @Test
    public void testCase5() {
        final String input = "ssun";
        final String expected = "sun";
        checkTest(input, expected);
    }

    private void suggestTest(final String input, final String[] expected) {
        final String[] actual = SPELL_CHECKER.suggest(input);
        Assertions.assertArrayEquals(expected, actual, "list of suggestions for the specified misspelled word");
    }

    @Test
    public void testCase6() {
        final String input = "helo";
        final String[] expected = {"hello"};
        suggestTest(input, expected);
    }

    @Test
    public void testCase7() {
        final String input = "goodbyee";
        final String[] expected = {"goodbye"};
        suggestTest(input, expected);
    }

    @Test
    public void testCase8() {
        final String input = "mooon";
        final String[] expected = {"moon"};
        suggestTest(input, expected);
    }

    @Test
    public void testCase9() {
        final String input = "ssun";
        final String[] expected = {"sun"};
        suggestTest(input, expected);
    }

    @Test
    public void testCase10() {
        final String input = "wrold";
        final String[] expected = {"world"};
        suggestTest(input, expected);
    }
}

