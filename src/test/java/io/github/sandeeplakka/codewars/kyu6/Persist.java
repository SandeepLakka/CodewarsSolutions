package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.

For example (Input --> Output):

39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
4 --> 0 (because 4 is already a one-digit number)

 */
class Persist {

    @Test
    public void tests() {
        assertEquals(3, persistence(39));
        assertEquals(4, persistence(999));
        assertEquals(0, persistence(4));
        assertEquals(2, persistence(25));
        assertEquals(3, persistence(444));

    }

    public static int persistence(long n) {
        // your code
        if (n < 10) return 0;
        return reduce(n, 0);
    }

    public static int reduce(long n, int count) {
        if (n < 10) return count;
        long newN = 1;
        while (n > 0) {
            newN = newN * (n % 10);
            n /= 10;
        }
        count += 1;
        return reduce(newN, count);

    }
}