package com.owodigi.two.pointers;

import java.util.*;

class RemoveDuplicatesForLoop extends RemoveDuplicates {

    @Override
    public int remove(List<Integer> arr) {
        return remove(arr.stream().mapToInt(Integer::intValue).toArray());
    }

    public int remove(final int[] arr) {
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
}
