package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Factorial

Description:

In mathematics, the factorial of a non-negative integer n, denoted by n!,
is the product of all positive integers less than or equal to n.

For example: 5! = 5 * 4 * 3 * 2 * 1 = 120.
By convention the value of 0! is 1.

Write a function to calculate factorial for a given input.
If input is below 0 or above 12 throw an exception to type IllegalArgumentException.

Categories : Fundamentals, Algorithms, Numbers
 */
public class Factorial {

    @Test
    public void test_factorial0() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorialV1(0));
        assertEquals(1, factorialV2(0));
    }

    @Test
    public void test_factorial1() {
        assertEquals(1, factorial(1));
        assertEquals(1, factorialV1(1));
        assertEquals(1, factorialV2(1));
    }

    @Test
    public void test_factorial2() {
        assertEquals(2, factorial(2));
        assertEquals(2, factorialV1(2));
        assertEquals(2, factorialV2(2));
    }

    @Test
    public void test_factorial3() {
        assertEquals(6, factorial(3));
        assertEquals(6, factorialV1(3));
        assertEquals(6, factorialV2(3));
    }

    @Test
    public void test_factorial4() {
        assertEquals(24, factorial(4));
        assertEquals(24, factorialV1(4));
        assertEquals(24, factorialV2(4));
    }

    @Test
    public void test_factorial5() {
        assertEquals(120, factorial(5));
        assertEquals(120, factorialV1(5));
        assertEquals(120, factorialV2(5));
    }

    @Test
    public void test_factorial6() {
        assertEquals(720, factorial(6));
        assertEquals(720, factorialV1(6));
        assertEquals(720, factorialV2(6));
    }

    @Test
    public void test_negativeFactorial1() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial(-1));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV1(-1));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV2(-1));
    }

    @Test
    public void test_negativeFactorial2() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial(-42));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV1(-42));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV2(-42));
    }

    @Test
    public void test_littleBiggerThan12() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial(13));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV1(13));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV2(13));
    }

    @Test
    public void test_biggerThan12() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial(42));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV1(42));
        assertThrows(IllegalArgumentException.class,
                () -> factorialV2(42));
    }

    //recursive approach
    public int factorial(int n) {
        if (n < 0 || n > 12) throw new IllegalArgumentException("Number should be between 0 and 12 (both inclusive)");
        // Happy coding :-)
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    //functional approach
    public int factorialV1(int n) {
        return Stream.of(n).filter(integer -> integer >= 0 && integer <= 12)
                .findAny()
                .map(integer -> IntStream.rangeClosed(1, integer)
                        .reduce(1, (a, b) -> a * b))
                .orElseThrow(IllegalArgumentException::new);
    }

    //iterative approach
    public int factorialV2(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Number should be between 0 and 12 (both inclusive)");
        }

        if (n == 0) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}