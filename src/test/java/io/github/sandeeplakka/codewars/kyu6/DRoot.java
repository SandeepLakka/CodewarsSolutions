package io.github.sandeeplakka.codewars.kyu6;

/*
  Digital root is the recursive sum of all the digits in a number.

  Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
  Examples

  16  -->  1 + 6 = 7
  942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
  132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
  493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2

  Categories : Algorithms, Mathematics, Numbers, Arithmetic
*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DRoot {
    @Test
    public void testDigitalRoot() {
        assertEquals(7, digital_root(16));
        assertEquals(6, digital_root(942));
        assertEquals(6, digital_root(132189));
        assertEquals(2, digital_root(493193));

        assertEquals(7, mindBlowing(16));
        assertEquals(6, mindBlowing(942));
        assertEquals(6, mindBlowing(132189));
        assertEquals(2, mindBlowing(493193));


    }

    public static int digital_root(int n) {
        if (n < 10) return n;
        int num = 0;
        while (n > 0) {
            num = num + n % 10;
            n /= 10;
        }
        return digital_root(num);
    }

    public static int mindBlowing(int n) {
        return (n != 0 && n % 9 == 0) ? 9 : n % 9;
    }
}