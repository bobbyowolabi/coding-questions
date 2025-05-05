package com.owodigi;

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
 * ---------------------------------------------------------
 * SANDBOX
 * ---------------------------------------------------------
 * REPEAT: (Outloud) to Test Understanding
 * CLARIFICATION: ...
 * EDGE CASES & CONSTRAINTS: ...
 * SOLUTIONS: ...
 * PATTERN: Binary Search | Two Pointers | Sliding Window | DFS | BFS ...
 * PSEUDOCODE (Optional):
 * -------------------
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class BankAccountAPI {

    interface Bank {
        public int credit(long accountId, int timestamp, int amount);
        public int debit(long accountId, int timestamp, int amount);
        public int balance(long accountId);
        public int balanceChange(long accountId, start, end)
    }

    @Test
    public void testCase1() {
    }
}
