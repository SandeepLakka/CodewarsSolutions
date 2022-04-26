package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void invalidTests() {
        assertThrows(IllegalArgumentException.class, () -> sumMul(0, 0), "n = 0, m = 0");
        assertThrows(IllegalArgumentException.class, () -> sumMul(4, -7), "n = 4, m = -7");
        assertThrows(IllegalArgumentException.class, () -> sumMul(-3, 10), "n = -3, m = 10");
    }

    public static long sumMul(int n, int m) {
        if (n < 0 || m < 0 || n == 0 || m == 0) throw new IllegalArgumentException("Invalid input");
        return IntStream.range(0, m).filter(value -> value % n == 0).peek(System.out::println).sum();
    }
}
