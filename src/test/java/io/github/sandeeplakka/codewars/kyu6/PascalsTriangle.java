package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PascalsTriangle {

    @Test
    public void testOneLevelTriangle() {
        final long[] terms = {1L};
        assertArrayEquals(terms, generate(1));
    }

    @Test
    public void testTwoLevelsTriangle() {
        final long[] terms = {1L, 1L, 1L};
        assertArrayEquals(terms, generate(2));
    }

    @Test
    public void testFourLevelsTriangle() {
        final long[] terms = {1L, 1L, 1L, 1L, 2L, 1L, 1L, 3L, 3L, 1L};
        assertArrayEquals(terms, generate(4));
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
}