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
 * STATUS: SOLVED ✅
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 * NOTES: where n is the number of words in the dictionary
 */
public class SpellChecker {
    private TrieNode root = new TrieNode();

    class TrieNode {
        String value;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
            this.value = null;
            isWord = false;
        }

        public TrieNode (final String value, final boolean isWord) {
            this.value =  value;
            this.isWord = isWord;
        }
    }

    private void insert(final String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            final char letter = word.charAt(i);
            TrieNode child = node.children.get(letter);
            if (child == null) {
                child = new TrieNode(String.valueOf(letter), false);
                node.children.put(letter, child);
            }
            node = child;
        }
        node.isWord = true;
        node.value = word;
    }

    private void words(final TrieNode node, final List<String> result) {
        for (final TrieNode child : node.children.values()) {
            if (child.isWord) {
                result.add(child.value);
            }
            words(child, result);
        }
    }

    public SpellChecker(final String[] dictionary) {
        for (final String word : dictionary) {
            insert(word);
        }
    }

    /**
     * Checks if the specified word is spelled correctly. If it is, returns the word. If it is not, returns
     * the first suggestion found in the dictionary.
     *
     * @param word
     * @return
     */
    public String check(final String word) {
        final String[] suggestions = suggest(word);
        return suggestions.length == 0 ? null : suggestions[0];
    }

    /**
     * Returns a list of suggestions for the specified misspelled word. Suggestions should be sorted by the
     * number of characters that match the misspelled word.
     *
     * @param word
     * @return
     */
    public String[] suggest(final String word) {
        TrieNode node = root;
        final List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) {
            final char letter = word.charAt(i);
            TrieNode child = node.children.get(letter);
            if (child == null) {
                words(node, suggestions);
                final String[] result = new String[suggestions.size()];
                return suggestions.toArray(result);
            }
            if (child.isWord) {
                suggestions.add(child.value);
            }
            node = child;
        }
        return new String[]{word};
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
        Assertions.assertArrayEquals(expected, actual, "Misspelled word suggestions for " + input + "; expected: " + Arrays.toString(expected) + "; actual: " + Arrays.toString(actual));
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

