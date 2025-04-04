package com.owodigi.two.pointers;

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
 * PATTERN: Binary Search | ...
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class ValidPalindrome  extends Palindrome{

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int leftIndex = 0, rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            final char left = s.charAt(leftIndex);
            final char right = s.charAt(rightIndex);
            if (!Character.isLetterOrDigit(left)) {
                ++leftIndex;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                --rightIndex;
                continue;
            }
            if (left != right) {
                return false;
            }
            ++leftIndex;
            --rightIndex;
        }
        return true;
    }
}
