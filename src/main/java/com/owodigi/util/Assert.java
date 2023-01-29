package com.owodigi.util;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class Assert {

    private static String toString(final Deque<String> stack) {
        return stack.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining("->"));
    }

    private static Deque<String> push(String value, Deque<String> stack) {
        stack.push(value);
        return stack;
    }

    private static void assertEquals(final Node expected, final Node actual, final Deque<String> stack) {
        if (expected == null) {
            Assertions.assertNull(actual, toString(stack));
            return;
        }
        Assertions.assertEquals(expected.data, actual.data, toString(stack) + ": data");
        assertEquals(expected.left, actual.left, push("left", stack));
        stack.pop();
        assertEquals(expected.right, actual.right, push("right", stack));
        stack.pop();
    }

    public static void assertEquals(final Node expected, final Node actual) {
        final Deque<String> stack = new ArrayDeque<>();
        stack.push("root");
        assertEquals(expected, actual, stack);
    }
}
