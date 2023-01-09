package com.owodigi.two.pointers;

import java.util.*;

class RemoveDuplicates {

    public static int remove(final int[] arr) {
        if (arr == null || arr.length == 1) {
            return -1;
        }
        int availableIndex = 1;
        for (int i = 1; i < arr.length; ++i) {
            final int previous = arr[i - 1];
            final int current = arr[i];
            if (current != previous) {
                arr[availableIndex++] = arr[i];
            }
        }
        return availableIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.print("result: " + RemoveDuplicates.remove(arr) + " input: " + Arrays.toString(arr) + "\n");

        arr = new int[]{2, 2, 2, 11};
        System.out.print("result: " + RemoveDuplicates.remove(arr) + " input: " + Arrays.toString(arr) + "\n");
    }
}
