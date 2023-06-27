package com.owodigi.arrays;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

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
public class ConnectFour {

    /**
     * Connect Four
     * 7x13 grid - generalized grid
     * 2 players
     * core game logic - player makes a move, then determines whether or not the player won
     */

    enum Player{_1, _2};

    class Game {
        final Player[][] board;

        public Game(final int columns, final int rows) {
            this.board = new Player[columns][rows];
        }

        /**
         * Return null if no winner; otherwise, return Player who won
         *
         * @return
         */
        public Player move(final Player player, final int column) throws Exception {
            int row = -1;
            for (int i = 0; i < board[column].length; ++i) {
                if (board[column][i] == null) {
                    row = i;
                    break;
                }
            }
            if (row == -1) {
                throw new Exception("This is an invalid move colum: " + column);
            } else {
                board[column][row] = player;
            }
            return winner(column, row);
        }

        private Player winner(final int column, final int row) {
            /* Column Win */
            final Player player = board[column][row];
            int columnCount = 0;
            for (int i = row - 1; i >= 0; --i) {
                if (board[column][i] == player) {
                    ++columnCount;
                } else {
                    break;
                }
            }
            final boolean columnWin = columnCount == 3;
            return columnWin ? player : null;
        }
    }

    /**
     | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
     |---|---|---|---|---|---|---|
     |   |   |   |   |   |   |   |
     |---|---|---|---|---|---|---|
     |   |   |   |   |   |   |   |
     |---|---|---|---|---|---|---|
     | 1 |   |   |   |   |   |   |
     |---|---|---|---|---|---|---|
     | 1 | 2 |   |   |   |   |   |
     |---|---|---|---|---|---|---|
     | 1 | 2 |   |   |   |   |   |
     |---|---|---|---|---|---|---|
     | 1 | 2 |   |   |   |   |   |
     */
    @Test
    public void testCase1() throws Exception{
        Game game = new Game(7, 13);
        game.move(Player._1, 0);
        game.move(Player._2, 1);
        game.move(Player._1, 0);
        game.move(Player._2, 1);
        game.move(Player._1, 0);
        game.move(Player._2, 1);
        final Player winner = game.move(Player._1, 0);
        Assertions.assertEquals(Player._1, winner, "Expected winner");
    }
}
