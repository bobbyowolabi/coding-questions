package com.owodigi.sliding.window;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringKDistinct {

    private static void add(final char c, final Map<Character, Integer> m) {
        Integer value = m.get(c);
        if (value == null) {
            value = 1;
        } else {
            ++value;
        }
        m.put(c, value);
    }

    private static void remove(final char c, final Map<Character, Integer> m) {
        Integer value = m.get(c);
        --value;
        if (value == 0) {
            m.remove(c);
        } else {
            m.put(c, value);
        }
    }

    public static int findLength(final String str, final int k) {
        final Map<Character, Integer> frequency = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int end = 0; end < str.length(); ++end) {
            final char next = str.charAt(end);
            add(next, frequency);
            if (frequency.size() == k) {
                maxLength = Math.max(maxLength, end - start + 1);
            } else {
                while (frequency.size() > k) {
                    remove(str.charAt(start++), frequency);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}

