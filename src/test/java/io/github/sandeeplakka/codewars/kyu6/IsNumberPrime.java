package io.github.sandeeplakka.codewars.kyu6;

/*
Description:

Define a function that takes one integer argument and
returns logical value true or false depending on if the integer is a 

Per Wikipedia, a prime number (or a prime) is a natural number greater than 1
that has no positive divisors other than 1 and itself.
Requirements

You can assume you will be given an integer input.
You can not assume that the integer will be only positive.
You may be given negative numbers as well (or 0).

NOTE on performance: There are no fancy optimizations required,
but still the most trivial solutions might time out.
Numbers go up to 2^31 (or similar, depends on language version).
Looping all the way up to n, or n/2, will be too slow.

Examples

is_prime(1)  // false
is_prime(2)  // true
is_prime(-1) // false

Categories : Algorithms, Mathematics, Numbers
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsNumberPrime {

    @Test
    public void testBasic() {
        assertFalse(isPrime(0), "0  is not prime");
        assertFalse(isPrime(1), "1  is not prime");
        assertTrue(isPrime(2), "2  is prime");
        assertTrue(isPrime(73), "73 is prime");
        assertFalse(isPrime(75), "75 is not prime");
        assertFalse(isPrime(-1), "-1 is not prime");
    }

    @Test
    public void testPrime() {
        assertTrue(isPrime(3), "3 is prime");
        assertTrue(isPrime(5), "5 is prime");
        assertTrue(isPrime(7), "7 is prime");
        assertTrue(isPrime(41), "41 is prime");
        assertTrue(isPrime(5099), "5099 is prime");
    }

    @Test
    public void testNotPrime() {
        assertFalse(isPrime(4), "4 is not prime");
        assertFalse(isPrime(6), "6 is not prime");
        assertFalse(isPrime(8), "8 is not prime");
        assertFalse(isPrime(9), "9 is not prime");
        assertFalse(isPrime(45), "45 is not prime");
        assertFalse(isPrime(-5), "-5 is not prime");
        assertFalse(isPrime(-8), "-8 is not prime");
        assertFalse(isPrime(-41), "-41 is not prime");
    }

    @Test
    public void testFewBigNumbers() {
        assertFalse(isPrime(1517688710), "1517688710 is not prime");
        assertFalse(isPrime(1461801948), "1461801948 is not prime");
        assertFalse(isPrime(1235840791), "1235840791 is prime");
        assertFalse(isPrime(1347121332), "1347121332 is not prime");
        assertFalse(isPrime(1145143529), "1145143529 is prime");
        assertFalse(isPrime(1947033857), "1947033857 is not prime");
        assertFalse(isPrime(1079456779), "1079456779 is prime");
        assertFalse(isPrime(1690278769), "1690278769 is not prime");
        assertFalse(isPrime(1353811289), "1353811289 is prime");
        assertFalse(isPrime(1950377509), "1950377509 is prime");
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}