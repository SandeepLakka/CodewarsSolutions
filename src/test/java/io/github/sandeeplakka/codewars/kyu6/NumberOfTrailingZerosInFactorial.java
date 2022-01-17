package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Description:

Write a program that will calculate the number of trailing zeros in a factorial of a given number.

N! = 1 * 2 * 3 * ... * N

Be careful 1000! has 2568 digits...

For more info, see: http://mathworld.wolfram.com/Factorial.html
Examples

zeros(6) = 1    --> 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero

zeros(12) = 2   --> 12! = 479001600 --> 2 trailing zeros

Hint: You're not meant to calculate the factorial. Find another way to find the number of zeros.

Categories : Algorithms, Mathematics, Numbers
 */
public class NumberOfTrailingZerosInFactorial {
    @Test
    public void tests_iterApproach() {
        assertEquals(0, zeros(0));
        assertEquals(1, zeros(6));
        assertEquals(2, zeros(14));
        assertEquals(7, zeros(30));
        assertEquals(24, zeros(100));
        assertEquals(249, zeros(1000));
        assertEquals(24999, zeros(100000));
        assertEquals(249999998, zeros(1000000000));
    }

    @Test
    public void tests_recurApproach() {
        assertEquals(0, zerosRecur(0));
        assertEquals(1, zerosRecur(6));
        assertEquals(2, zerosRecur(14));
        assertEquals(7, zerosRecur(30));
        assertEquals(24, zerosRecur(100));
        assertEquals(249, zerosRecur(1000));
        assertEquals(24999, zerosRecur(100000));
        assertEquals(249999998, zerosRecur(1000000000));
    }


    //iterative approach
    public static int zeros(int n) {
        int s = 0;
        while (n > 0) {
            n /= 5;
            s += n;
        }

        return s;
    }

    //recursive approach : didn't like this for this problem statement
    public static int zerosRecur(int n) {
        if (n / 5 == 0) return 0;
        return n / 5 + zeros(n / 5);
    }
}