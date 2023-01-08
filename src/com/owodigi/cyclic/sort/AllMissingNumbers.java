package com.owodigi.cyclic.sort;

import java.util.*;

/**
 * Not Completed, the sorting portion does not work.
 */
class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        final List<Integer> sortedNums = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            sortedNums.add(nums[i] - 1, nums[i]);
        }
        final List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < sortedNums.size(); ++i) {
            if (sortedNums.get(i) != i + 1) {
                missingNumbers.add(sortedNums.get(i));
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
