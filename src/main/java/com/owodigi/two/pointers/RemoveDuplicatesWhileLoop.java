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
public class RemoveDuplicatesWhileLoop extends RemoveDuplicates {

    @Override
    public int remove(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr.size();
        }
        int writeIndex = 0, readIndex = 1;
        while (readIndex < arr.size()) {
            if (arr.get(writeIndex) != arr.get(readIndex)) {
                arr.set(++writeIndex, arr.get(readIndex));
            }
            ++readIndex;
        }
        return writeIndex + 1;
    }
}
