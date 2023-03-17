package com.owodigi.breadth.first.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 */
public class FloodFill {

    class Point {
        int x;
        int y;
        public Point(final int x, final int y) {
            this. x = x;
            this.y = y;
        }
    }

    private boolean inBounds(final int x, final int y, int[][] image) {
        if (y < image.length) {
            final int[] row = image[y];
            if (x < row.length) {
                return true;
            }
        }
        return false;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final Queue<Point> toVisit = new ArrayDeque<>();
        toVisit.add(new Point(sr, sc));
        while (toVisit.isEmpty() == false) {
            final Point next = toVisit.poll();
            final int nextColor = image[next.x][next.y];
            if (nextColor != color) {
                image[next.x][next.y] = color;
                if (inBounds(next.x, next.y + 1, image)) {
                    toVisit.add(new Point(next.x, next.y + 1));
                } else if (inBounds(next.x + 1, next.y, image)) {
                    toVisit.add(new Point(next.x + 1, next.y));
                } else if (inBounds(next.x, next.y - 1, image)) {
                    toVisit.add(new Point(next.x, next.y - 1));
                } else if (inBounds(next.x - 1, next.y, image)) {
                    toVisit.add(new Point(next.x - 1, next.y));
                }
            }
        }
        return image;
    }

    @Test
    public void testCase1() {
        final int[][] input = {{1,1,1},{1,1,0},{1,0,1}};
        final int[][] expected = {{2,2,2},{2,2,0},{2,0,1}};
        final int sr = 1;
        final int sc = 1;
        final int color = 2;
        final int[][] actual = floodFill(input, sr, sc, color);
        for (int i = 0; i < expected.length; ++i) {
            final int[] expectedRow = expected[i];
            final int[] actualRow = actual[i];
            final String message = "row " + i + ": expected " + Arrays.toString(expectedRow) + " actual " + Arrays.toString(actualRow);
            Assertions.assertArrayEquals(expectedRow, actualRow, message);
        }
    }
}
