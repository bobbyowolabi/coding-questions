package com.owodigi.depth.first.search;

import com.owodigi.util.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * TITLE: Flood Fill
 * LEVEL: Easy
 * STATUS: NOT SOLVED ❌
 * PROBLEM STATEMENT: An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 *
 * SAMPLE DATA:
 *    image = [[1,1,1],[1,1,0],[1,0,1]]
 *    +---+---+---+
 *    | 1 | 1 | 1 |
 *    | 1 | 1 | 0 |
 *    | 1 | 0 | 1 |
 *    +---+---+---+
 *    sr = 1, sc = 1, color = 2
 *    Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sample Data:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * +---+---+---+
     * | 1 | 1 | 1 |
     * | 1 | 1 | 0 |
     * | 1 | 0 | 1 |
     * +---+---+---+
     */
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

    /**
     * Sample Data:
     * image = [[0,0,0],[1,0,0]]
     * +---+---+---+
     * | 0 | 0 | 0 |
     * | 1 | 0 | 0 |
     * +---+---+---+
     */
    @Test
    public void testCase2() {
        final int[][] input = {{0,0,0},{1,0,0}};
        final int[][] expected = {{0,0,0,},{2,0,0}};
        final int sr = 1;
        final int sc = 0;
        final int color = 2;
        final int[][] actual = floodFill(input, sr, sc, color);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Sample Data
     * image = [[0,0,0],[0,0,0]]
     * +---+---+---+
     * | 0 | 0 | 0 |
     * | 0 | 0 | 0 |
     * +---+---+---+
     */
    @Test
    public void testCase3() {
        final int[][] input = {{0,0,0},{0,0,0}};
        final int[][] expected = {{0,0,0,},{0,0,0}};
        final int sr = 0;
        final int sc = 0;
        final int color = 0;
        final int[][] actual = floodFill(input, sr, sc, color);
        Assert.assertEquals(expected, actual);
    }
}
