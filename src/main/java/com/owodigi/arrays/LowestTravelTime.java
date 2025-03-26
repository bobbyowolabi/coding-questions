package com.owodigi.arrays;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * TITLE:
 * LEVEL: Easy 🟩 | Medium 🟨 | Hard 🟥
 * PROBLEM STATEMENT: Here is an n*n map where grid[i][j] represents the number of obstacles in the position (i, j).
 * In every unit of time, the number of obstacles in every position will be decreased by one. Every position with one
 * or more obstacles is not accessible.
 *
 * Assume you are a dasher at DoorDash. You can drive from one position to another 4-directionally adjacent
 * position (up/down/left/right) if and only if the position is accessible. You will start at the top left
 * position (0, 0) and your goal is to reach the bottom right position (n-1, n-1). Assuming you can drive infinite
 * distances in zero time, what would be the least time that you can reach the destination?
 *
 *  Constraints:
 *  n == grid.length
 *  n == grid[i].length
 *  1 <= n <= 50
 *  0 <= grid[i][j] < n^2
 *  Each value grid[i][j] is unique.
 *
 * SAMPLE DATA:
 * 0  1  2  3  4
 * 24 16 22 21 5
 * 12 13 14 15 23
 * 11 17 18 19 20
 * 10 9  8  7  6
 *
 * Input: grid = [[0,1,2,3,4],[24,16,22,21,5],[12,13,14,15,23],[11,17,18,19,20],[10,9,8,7,6]]
 *
 * t=0, position=0,0, - no where to go, (0,1) the fastest time
 * t=1, position=0,0; position 0,1 is now open, move to position=0,1
 * ...
 *
 * Output: 16
 *
 *
 * -------------------
 * STATUS: SOLVED ✅ | NOT SOLVED ❌ | PARTIALLY SOLVED ☑️
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class LowestTravelTime {

    class Position {
        int value;
        int i;
        int j;

        public Position(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    int fastestTime(final int[][] grid) {
        final TreeSet<Position> seen = new TreeSet<>(Comparator.comparingInt(position -> position.value));
        int i = 0, j = 0;
        int maxSeen = 0;
        while(i != grid.length && j != grid[0].length) {
            if (i - 1 <= 0 && j < grid[0].length) {
                seen.add(new Position(i - 1, j, grid[i - 1][j]));
            } else if (i + 1 < grid.length && j < grid[0].length) {
                seen.add(new Position(i + 1, j, grid[i][j]));
            } else if((i >= 0 && i < grid.length) && (j - + 11 >= 0)) {
                seen.add(new Position(i, j - 1, grid[i][j - 1]));
            } else if((i >= 0 && i < grid.length) && (j + 1 < grid[0].length)) {
                seen.add(new Position(i, j + 1, grid[i][j]));
            }
            final Position lowestSeen = seen.first();
            i = lowestSeen.i;
            j = lowestSeen.j;
            maxSeen = Math.max(maxSeen, lowestSeen.value);
        }
        return maxSeen;
    }

    static int addNumbers(int a, int b) {
        return a+b;
    }
}
