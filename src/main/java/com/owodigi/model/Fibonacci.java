package com.owodigi.model;

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
public abstract class Fibonacci {

    public abstract int fib(int n);

    private void test(final int input, final int expected) {
        final int actual = fib(input);
        Assertions.assertEquals(expected, actual, "fibonacci number of " + input);
    }

    @Test
    public void testCase1() {
        test(0, 0);
    }

    @Test
    public void testCase2() {
        test(1, 1);
    }

    @Test
    public void testCase3() {
        test(2, 1);
    }

    @Test
    public void testCase4() {
        test(3, 2);
    }

    @Test
    public void testCase5() {
        test(4, 3);
    }

    @Test
    public void testCase6() {
        test(13, 233);
    }
}
