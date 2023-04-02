package com.owodigi.binary.search;

import java.util.*;

import com.owodigi.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: First Bad Version
 * LEVEL: Easy
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT: You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * SAMPLE DATA:
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int candidate = n;
        while (candidate >= 0 && candidate <= n) {
            final Double midPoint = Math.ceil((candidate + n) / 2.0);
            candidate = midPoint.intValue();
            if (isBadVersion(candidate)) {
                while (--candidate >= 0) {
                    if (isBadVersion(candidate) == false) {
                        return candidate + 1;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    @Test
    public void testCase1() {
        final int n = 5;
        final int expected = 4;
        setFirstBadVersion(expected);
        final int actual = firstBadVersion(n);
        Assertions.assertEquals(expected, actual, "First Bad Version");
    }
}
