package com.owodigi.stack;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Valid Parentheses
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * SAMPLE DATA:
 * Input: s = "()"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(final String s) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            final char next = s.charAt(i);
            if (next == '(' || next == '{' || next == '[') {
                stack.push(next);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                final char open = stack.pop();
                if (next == '}') {
                    if (open != '{')
                        return false;
                } else if (next == ']') {
                    if (open != '[')
                        return false;
                } else if (next == ')') {
                    if (open != '(')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private void test(final String input, final boolean expected) {
        final boolean actual = isValid(input);
        Assertions.assertEquals(expected, actual, "Parentheses is valid");
    }

    @Test
    public void testCase1() {
        test("()", true);
    }

    @Test
    public void testCase2() {
        test("()[]{}", true);
    }

    @Test
    public void testCase3() {
        test("(]", false);
    }
}
