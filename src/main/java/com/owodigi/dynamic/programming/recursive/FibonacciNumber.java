package com.owodigi.dynamic.programming.recursive;

import java.util.*;

import com.owodigi.model.Fibonacci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class FibonacciNumber extends Fibonacci {

    private int fib(final int n, final int[] arr) {
        if (n == 0) {
            return arr[n] = 0;
        } else if (n == 1) {
            return arr[n] = 1;
        } else if (arr[n] == 0) {
            return arr[n] = fib(n - 1, arr) + fib(n - 2, arr);
        } else {
            return arr[n];
        }
    }

    public int fib(int n) {
        return fib(n, new int[n + 1]);
    }

    @Test
    public void sampleData1() {
    }
}
