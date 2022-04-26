package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Sum of Multiples

Your Job

Find the sum of all multiples of n below m
Keep in Mind

    n and m are natural numbers (positive integers)
    m is excluded from the multiples

Examples

sumMul(2, 9)   ==> 2 + 4 + 6 + 8 = 20
sumMul(3, 13)  ==> 3 + 6 + 9 + 12 = 30
sumMul(4, 123) ==> 4 + 8 + 12 + ... = 1860
sumMul(4, -7)  // throws IllegalArgumentException

Categories : Fundamentals, Loops, Control Flow, Basic Language Features
 */
public class SumOfMultiples {
    @Test
    void basicTests() {
        assertEquals(20, sumMul(2, 9), "n = 2, m = 9");
        assertEquals(30, sumMul(5, 20), "n = 5, m = 20");
        assertEquals(1860, sumMul(4, 123), "n = 4, m = 123");
        assertEquals(86469, sumMul(123, 4567), "n = 123, m = 4567");

        assertEquals(20, sumMulV1(2, 9), "n = 2, m = 9");
        assertEquals(30, sumMulV1(5, 20), "n = 5, m = 20");
        assertEquals(1860, sumMulV1(4, 123), "n = 4, m = 123");
        assertEquals(86469, sumMulV1(123, 4567), "n = 123, m = 4567");

    }

    @Test
    void invalidTests() {
        assertThrows(IllegalArgumentException.class, () -> sumMul(0, 0), "n = 0, m = 0");
        assertThrows(IllegalArgumentException.class, () -> sumMul(4, -7), "n = 4, m = -7");
        assertThrows(IllegalArgumentException.class, () -> sumMul(-3, 10), "n = -3, m = 10");

        assertThrows(IllegalArgumentException.class, () -> sumMulV1(0, 0), "n = 0, m = 0");
        assertThrows(IllegalArgumentException.class, () -> sumMulV1(4, -7), "n = 4, m = -7");
        assertThrows(IllegalArgumentException.class, () -> sumMulV1(-3, 10), "n = -3, m = 10");

    }

    @RepeatedTest(10)
    void randomTests() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            int n = rand.nextInt(-100, 1_000);
            int m = rand.nextInt(-100, 10_000);

            if (n < 1 || m < 1) {
                assertThrows(IllegalArgumentException.class, () -> sumMul(n, m), "n = " + n + ", m = " + m);
                assertThrows(IllegalArgumentException.class, () -> sumMulV1(n, m), "n = " + n + ", m = " + m);
            } else {
                int k = (m - 1) / n;
                int expected = k * (k + 1) / 2 * n;
                assertEquals(expected, sumMul(n, m), "n = " + n + ", m = " + m);
                assertEquals(expected, sumMulV1(n, m), "n = " + n + ", m = " + m);
            }
        }

    }

    public static long sumMul(int n, int m) {
        if (n < 1 || m < 1) throw new IllegalArgumentException("Invalid input");
        return IntStream.range(0, m).filter(value -> value % n == 0).sum();
    }

    public static long sumMulV1(int n, int m) {
        if (n < 1 || m < 1) throw new IllegalArgumentException("Invalid inputs");
        long x = (m - 1) / n;
        return (n * x * (x + 1) / 2);
    }
}
