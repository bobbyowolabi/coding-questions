package com.owodigi.breadth.first.search;

import java.util.*;

import com.owodigi.util.Assert;
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

    private boolean inBounds(final Point point, int[][] image) {
        if (point.y >= 0 && point.y < image.length) {
            final int[] row = image[point.y];
            if (point.x >= 0 && point.x < row.length) {
                return true;
            }
        }
        return false;
    }

    private int getColor(final Point point, final int[][] image) {
        return image[point.y][point.x];
    }

    private void setColor(final Point point, final int color, final int[][] image) {
        image[point.y][point.x] = color;
    }

    private void addToVisit(final Point point, final int startingColor, final int fillColor, final int[][] image, final Queue<Point> toVisit) {
        if (inBounds(point, image)) {
            final int pixelColor = getColor(point, image);
            if (pixelColor == startingColor && pixelColor != fillColor) {
                toVisit.add(point);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final Queue<Point> toVisit = new ArrayDeque<>();
        final Point start = new Point(sr, sc);
        final int startColor = getColor(start, image);
        addToVisit(start, startColor, color, image, toVisit);
        while (toVisit.isEmpty() == false) {
            final Point next = toVisit.poll();
            setColor(next, color, image);
            final Point up = new Point(next.x, next.y + 1);
            final Point right = new Point(next.x + 1, next.y);
            final Point down = new Point(next.x, next.y + 1);
            final Point left = new Point(next.x - 1, next.y);
            addToVisit(up, startColor, color, image, toVisit);
            addToVisit(right, startColor, color, image, toVisit);
            addToVisit(down, startColor, color, image, toVisit);
            addToVisit(left, startColor, color, image, toVisit);
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
        Assert.assertEquals(expected, actual);
    }
}
