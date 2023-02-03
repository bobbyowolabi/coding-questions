package com.owodigi.dynamic.programming.iterative;

import com.owodigi.model.Fibonacci;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class FibonacciNumber extends Fibonacci {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        final int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
