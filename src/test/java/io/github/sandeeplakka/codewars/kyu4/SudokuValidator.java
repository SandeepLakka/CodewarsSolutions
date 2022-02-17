package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

    public static boolean check(int[][] sudoku) {
        //do your magic
        for (int i = 0; i < 9; i++) {
            Set<Integer> values = new HashSet<Integer>() {{
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
                add(8);
                add(9);
            }};
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0 || !values.contains(sudoku[i][j])) return false;
                values.remove(sudoku[i][j]);
            }
            if (!values.isEmpty()) return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Integer> values = new HashSet<Integer>() {{
                    add(1);
                    add(2);
                    add(3);
                    add(4);
                    add(5);
                    add(6);
                    add(7);
                    add(8);
                    add(9);
                }};

                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (!values.contains(sudoku[x][y])) return false;
                        values.remove(sudoku[x][y]);
                    }
                }
                if (!values.isEmpty()) return false;
            }
        }
        return true;
    }
}