package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Pascal's Triangle

n mathematics, Pascal's triangle is a triangular array of the binomial coefficients expressed with formula nCx

nCx = n!/(n-x)!x!


where n denotes a row of the triangle, and x is a position of a term in the row.

Task

Write a function that, given a depth n, returns n top rows of Pascal's
Triangle flattened into a one-dimensional list/array.

Example:
n = 1: [1]
n = 2: [1,  1, 1]
n = 4: [1,  1, 1,  1, 2, 1,  1, 3, 3, 1]

Note:
Beware of overflow. Requested terms of a triangle are guaranteed to fit into the returned type,
but depending on seleced method of calculations, intermediate values can be larger.

Categories : Arrays, Mathematics, Algorithms
 */
public class PascalsTriangle {

    @Test
    public void testOneLevelTriangle() {
        final long[] terms = {1L};
        assertArrayEquals(terms, generate(1));
        assertArrayEquals(terms, generate_clever_simple(1));
    }

    @Test
    public void testTwoLevelsTriangle() {
        final long[] terms = {1L, 1L, 1L};
        assertArrayEquals(terms, generate(2));
        assertArrayEquals(terms, generate_clever_simple(2));

    }

    @Test
    public void testFourLevelsTriangle() {
        final long[] terms = {1L, 1L, 1L, 1L, 2L, 1L, 1L, 3L, 3L, 1L};
        assertArrayEquals(terms, generate(4));
        assertArrayEquals(terms, generate_clever_simple(4));

    }

    public static long[] generate(int level) {
        long[][] values = new long[level][level];
        return LongStream.range(0, level).flatMap(val -> {
            int n = (int) val;
            return IntStream.rangeClosed(0, n).mapToLong(x -> {
                if (values[n][x] != 0) return values[n][x];
                if (values[n][n - x] != 0) return values[n][n - x];
                return values[n][x] = getNcX(n, x);
            });
        }).toArray();
    }

    private static long getNcX(int n, int k) {
        if (k > n - k)
            k = n - k;

        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--)
            b = b * m / i;
        return b;
    }


    static long[] generate_clever_simple(int level) {
        long[] pascal = new long[level * (level + 1) / 2];
        for (int i = 0, l = 0; l < level; l++) {
            for (long f = 1, k = 0; k <= l; f = f * (l - k) / (k + 1), k++) {
                pascal[i++] = f;
            }
        }
        return pascal;
    }
}