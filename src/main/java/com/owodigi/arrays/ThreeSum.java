package com.owodigi.arrays;

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
public class ThreeSum {

    public record Triplet(int num1, int num2, int num3){}




    private boolean condition(final int i, final int j, final int k) {
        return (i != j) &&  (i != k) && (j != k);
    }

    private boolean condition(final int i, final int j, final Set<Integer> nums) {
        for (int k : nums) {
            if ((i != j) &&  (i != k) && (j != k)) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final Map<Integer, Set<Integer>> numsToIndices = new HashMap<>();
        final Set<Triplet> visited = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            final int num = nums[i];
            Set<Integer> indicies = numsToIndices.get(num);
            if (indicies == null) {
                indicies = new HashSet<>();
                numsToIndices.put(num, indicies);
            }
            indicies.add(i);
        }
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                final int num1 = nums[i];
                final int num2 = nums[j];
                final int num3 = Math.negateExact(num1 + num2);
                final Set<Integer> num3Indices = numsToIndices.get(num3);
                if (num3Indices != null) {
                    for (final int k : num3Indices) {
                        final Triplet triplet = new Triplet(num1, num2, num3);
                        if (condition(i, j, k) && !visited.contains(triplet)) {
                            result.add(Arrays.asList(num1, num2, num3));
                        }
                        visited.add(triplet);
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void testCase1() {
        final int[] input = new int[]{-1,0,1,2,-1,-4};
        final List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1,-1,2),
                Arrays.asList(-1,0,1));
        final List<List<Integer>> actual = threeSum(input);
        Assertions.assertIterableEquals(expected, actual,
                "3 Sum of " + Arrays.toString(input) +
                "\nexpected " + Arrays.deepToString(expected.toArray()) +
                "\nactual " + Arrays.deepToString(actual.toArray()));
    }
}
