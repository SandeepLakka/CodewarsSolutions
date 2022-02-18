package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Sudoku Solution Validator

Sudoku Background

Sudoku is a game played on a 9x9 grid.
The goal of the game is to fill all cells of the grid with digits from 1 to 9,
so that each column, each row, and each of the nine 3x3 sub-grids (also known as blocks)
contain all of the digits from 1 to 9.
(More info at: http://en.wikipedia.org/wiki/Sudoku)
Sudoku Solution Validator

Write a function validSolution/ValidateSolution/valid_solution()
that accepts a 2D array representing a Sudoku board, and returns true if it is a valid solution,
or false otherwise. The cells of the sudoku board may also contain 0's, which will represent empty cells.
Boards containing one or more zeroes are considered to be invalid solutions.

The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.
Examples

validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 5, 3, 4, 8],
  [1, 9, 8, 3, 4, 2, 5, 6, 7],
  [8, 5, 9, 7, 6, 1, 4, 2, 3],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 6, 1, 5, 3, 7, 2, 8, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 4, 5, 2, 8, 6, 1, 7, 9]
]); // => true

validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 0, 3, 4, 8],
  [1, 0, 0, 3, 4, 2, 5, 6, 0],
  [8, 5, 9, 7, 6, 1, 0, 2, 0],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 0, 1, 5, 3, 7, 2, 1, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 0, 0, 4, 8, 1, 1, 7, 9]
]); // => false

Categories : Algorithms, Data Structures, Validation

 */
public class SudokuValidator {
    @Test
    void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        assertTrue(check(sudoku));

        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;

        assertFalse(check(sudoku));

        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;

        sudoku[4][4] = 0;

        assertFalse(check(sudoku));
    }

    @Test
    void subsquaresTest() {
        int[][] sudoku = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };
        assertFalse(check(sudoku));
    }

    @Test
    public void test3() {
        int[][] sudoku = {
                {8, 7, 9, 1, 2, 3, 5, 4, 6},
                {2, 1, 3, 4, 5, 6, 8, 7, 9},
                {5, 4, 6, 7, 8, 9, 2, 1, 3},
                {6, 5, 7, 8, 9, 1, 3, 2, 4},
                {9, 8, 1, 2, 3, 4, 6, 5, 7},
                {3, 2, 4, 5, 6, 7, 9, 8, 1},
                {1, 9, 2, 3, 4, 5, 7, 6, 8},
                {7, 6, 8, 9, 1, 2, 4, 3, 5},
                {4, 3, 5, 6, 7, 8, 1, 9, 2},
        };
        assertTrue(check(sudoku));
    }

    @Test
    public void test4() {
        int[][] sudoku = {
                {3, 2, 1, 5, 4, 6, 8, 9, 7},
                {9, 8, 7, 2, 1, 3, 5, 6, 4},
                {6, 5, 4, 8, 7, 9, 2, 3, 1},
                {7, 6, 5, 9, 8, 1, 3, 4, 2},
                {4, 3, 2, 6, 5, 7, 9, 1, 8},
                {1, 9, 8, 3, 2, 4, 6, 7, 5},
                {5, 4, 3, 7, 6, 8, 1, 2, 9},
                {2, 1, 9, 4, 3, 5, 7, 8, 6},
                {8, 7, 6, 1, 9, 2, 4, 5, 3},
        };
        assertTrue(check(sudoku));
    }

    @Test
    public void test5() {
        int[][] sudoku = {
                {5, 7, 3, 3, 7, 5, 4, 4, 0},
                {0, 5, 4, 1, 2, 1, 1, 5, 4},
                {7, 2, 4, 4, 6, 9, 5, 5, 7},
                {8, 7, 8, 7, 0, 6, 5, 1, 1},
                {5, 6, 5, 8, 1, 9, 8, 1, 7},
                {1, 5, 8, 2, 7, 2, 6, 7, 9},
                {5, 3, 2, 4, 4, 6, 4, 0, 5},
                {4, 6, 0, 9, 0, 6, 1, 4, 5},
                {2, 0, 2, 7, 1, 7, 9, 1, 3},
        };
        assertFalse(check(sudoku));
    }

    @Test
    public void test6() {
        int[][] sudoku = {
                {8, 6, 9, 1, 2, 5, 7, 3, 4},
                {1, 8, 2, 3, 4, 7, 9, 5, 6},
                {3, 1, 4, 5, 6, 9, 2, 7, 8},
                {9, 7, 1, 2, 3, 6, 8, 4, 5},
                {7, 5, 8, 9, 1, 4, 6, 2, 3},
                {5, 3, 6, 7, 8, 2, 4, 9, 1},
                {2, 9, 3, 4, 5, 8, 1, 6, 7},
                {6, 4, 7, 8, 9, 3, 5, 1, 2},
                {4, 2, 5, 6, 7, 1, 3, 8, 9},
        };
        assertFalse(check(sudoku));
    }

    @Test
    public void test7() {
        int[][] sudoku = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6}
        };
        assertFalse(check(sudoku));

    }

    @Test
    public void test8() {
        int[][] sudoku = {
                {3, 2, 11, 5, 4, 6, 8, 9, 7},
                {9, 8, 7, 2, 1, 3, 5, 6, 4},
                {6, 5, 4, 8, 7, 9, 2, 3, 1},
                {7, 6, 5, 9, 8, 1, 3, 4, 2},
                {4, 3, 2, 6, 5, 7, 9, 1, 8},
                {1, 9, 8, 3, 2, 4, 6, 7, 5},
                {5, 4, 3, 7, 6, 8, 1, 2, 9},
                {2, 1, 9, 4, 3, 5, 7, 8, 6},
                {8, 7, 6, 1, 9, 2, 4, 5, 13},
        };
        assertFalse(check(sudoku), "booooo....");
    }

    public static boolean check(int[][] sudoku) {
        //do your magic
        final int SIZE = sudoku.length;

        //Rows check
        if (validateLine(sudoku, SIZE, true)) return false;

        //Columns check
        if (validateLine(sudoku, SIZE, false)) return false;

        //Sub squares check
        final int SUB_SQUARE_SIZE = (int) Math.sqrt(SIZE);
        if (SUB_SQUARE_SIZE * SUB_SQUARE_SIZE != SIZE) {
            throw new RuntimeException("Sudoku is not an NXN board");
        }
        for (int i = 0; i < SIZE; i += SUB_SQUARE_SIZE) {
            for (int j = 0; j < SIZE; j += SUB_SQUARE_SIZE) {
                Set<Integer> values = IntStream.rangeClosed(1, SIZE)
                        .boxed()
                        .collect(Collectors.toSet());
                for (int x = 0; x < SUB_SQUARE_SIZE; x++) {
                    for (int y = 0; y < SUB_SQUARE_SIZE; y++) {
                        if (!values.contains(sudoku[i + x][j + y])) return false;
                        values.remove(sudoku[i + x][j + y]);
                    }
                }
                if (!values.isEmpty()) return false;
            }
        }
        return true;
    }

    private static boolean validateLine(int[][] sudoku, int SIZE, boolean isRow) {
        for (int i = 0; i < SIZE; i++) {
            Set<Integer> values = IntStream.rangeClosed(1, SIZE)
                    .boxed()
                    .collect(Collectors.toSet());
            for (int j = 0; j < SIZE; j++) {
                int row, column;
                if (isRow) {
                    row = i;
                    column = j;
                } else {
                    row = j;
                    column = i;
                }
                if (sudoku[row][column] == 0 || !values.contains(sudoku[row][column])) return true;
                values.remove(sudoku[row][column]);
            }
            if (!values.isEmpty()) return true;
        }
        return false;
    }
}