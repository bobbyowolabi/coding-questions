package com.owodigi.hash.table;

import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Ransom Note
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
 * the letters from magazine and false otherwise.  Each letter in magazine can only be used once in ransomNote.
 * SAMPLE DATA:
 * Input: ransomNote = "a", magazine = "b"
 */
public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < magazine.length(); ++i) {
            final char c = magazine.charAt(i);
            Integer frequency = frequencies.get(c);
            if (frequency == null) {
                frequency = 1;
            } else {
                ++frequency;
            }
            frequencies.put(c, frequency);
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            final char c = ransomNote.charAt(i);
            Integer frequency = frequencies.get(c);
            if (frequency == null || frequency == 0) {
                return false;
            } else {
                --frequency;
                frequencies.put(c, frequency);
            }
        }
        return true;
    }

    @Test
    public void sampleData1() {
        final String note = "a";
        final String magazine = "b";
        final boolean expected = false;
        final boolean actual = new RansomeNote().canConstruct(note, magazine);
        Assertions.assertEquals(expected, actual, "Can construct '" + note + "' with magazine '" + magazine + "'");
    }

    @Test
    public void sampleData2() {
        final String note = "aa";
        final String magazine = "ab";
        final boolean expected = false;
        final boolean actual = new RansomeNote().canConstruct(note, magazine);
        Assertions.assertEquals(expected, actual, "Can construct '" + note + "' with magazine '" + magazine + "'");
    }

    @Test
    public void sampleData3() {
        final String note = "aa";
        final String magazine = "aab";
        final boolean expected = true;
        final boolean actual = new RansomeNote().canConstruct(note, magazine);
        Assertions.assertEquals(expected, actual, "Can construct '" + note + "' with magazine '" + magazine + "'");
    }

    @Test
    public void sampleData4() {
        final String note = "aa";
        final String magazine = "";
        final boolean expected = false;
        final boolean actual = new RansomeNote().canConstruct(note, magazine);
        Assertions.assertEquals(expected, actual, "Can construct '" + note + "' with magazine '" + magazine + "'");
    }
}
