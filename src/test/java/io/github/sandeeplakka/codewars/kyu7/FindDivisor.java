package io.github.sandeeplakka.codewars.kyu7;

/*
Count the divisors of a number

Count the number of divisors of a positive integer n.

Random tests go up to n = 500000.


Examples (input --> output)

4 --> 3 (1, 2, 4)
5 --> 2 (1, 5)
12 --> 6 (1, 2, 3, 4, 6, 12)
30 --> 8 (1, 2, 3, 5, 6, 10, 15, 30)

Categories : Fundamentals, Arithmetic, Mathematics, Algorithms, Numbers
 */

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDivisor {
    @Test
    public void oneTest() {
        assertEquals(1, numberOfDivisors(1), "Should return 1 if the parameter equals 1");
    }

    @Test
    public void fourTest() {
        assertEquals(3, numberOfDivisors(4), "Should return 3 if the parameter equals 4");
    }

    @Test
    public void fiveTest() {
        assertEquals(2, numberOfDivisors(5), "Should return 2 if the parameter equals 5");
    }

    @Test
    public void twelveTest() {
        assertEquals(6, numberOfDivisors(12), "Should return 6 if the parameter equals 12");
    }

    @Test
    public void thirtyTest() {
        int n = 0;
        int num = 0;
        assertEquals(num, numberOfDivisors(n), "Should return " + num + " if the parameter equals " + n);
    }

    @Test
    public void bigNumsTes() {
        assertEquals(24, numberOfDivisors(135261), "Should return 24 if the parameter equals 135261");
        assertEquals(12, numberOfDivisors(305556), "Should return 12 if the parameter equals 305556");
        assertEquals(6, numberOfDivisors(109948), "Should return 6 if the parameter equals 109948");
        assertEquals(24, numberOfDivisors(174537), "Should return 24 if the parameter equals 174537");
        assertEquals(24, numberOfDivisors(327063), "Should return 24 if the parameter equals 327063");
        assertEquals(4, numberOfDivisors(57755), "Should return 4 if the parameter equals 57755");
        assertEquals(12, numberOfDivisors(281740), "Should return 12 if the parameter equals 281740");
        assertEquals(16, numberOfDivisors(416344), "Should return 16 if the parameter equals 416344");
    }

    public long numberOfDivisors(int n) {
        return IntStream.rangeClosed(1, n).filter(val -> n % val == 0).count();
    }

}