package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
 * Multiplication table
 *
 * Your task, is to create N×N multiplication table, of size provided in parameter.
 *
 * For example, when given size is 3:
 *
 * 1 2 3
 * 2 4 6
 * 3 6 9
 *
 * For the given example, the return value should be:
 *
 * [[1,2,3],[2,4,6],[3,6,9]]
 *
 * Categories : Arrays, Fundamentals
 */
public class Multiplication {

    public static int[][] multiplicationTable(int n) {
        int[][] result = new int[n][n];
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                result[row - 1][col - 1] = row * col;
            }
        }
        return result;
    }

    public static int[][] multiplicationTableV2(int n) {

        int[][] result = new int[n][n];
        IntStream.rangeClosed(1, n).forEach(row -> IntStream.rangeClosed(1, n).forEach(col -> result[row - 1][col - 1] = row * col));
        return result;
    }


    @Test
    @DisplayName("n = 3")
    void test3() {
        int[][] test = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertArrayEquals(test, Multiplication.multiplicationTable(3));
        assertArrayEquals(test, Multiplication.multiplicationTableV2(3));
    }

    @Test
    @DisplayName("n = 1")
    void test1() {
        int[][] test1 = {{1}};
        assertArrayEquals(test1, Multiplication.multiplicationTable(1));
        assertArrayEquals(test1, Multiplication.multiplicationTableV2(1));
    }

}