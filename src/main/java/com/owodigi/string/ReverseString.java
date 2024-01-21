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
public class ReverseString {

    public void reverseString(final char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            ++start;
            --end;
        }
    }

    @Test
    public void testCase1() {
    }
}
