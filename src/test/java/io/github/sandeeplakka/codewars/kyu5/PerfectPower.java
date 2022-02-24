package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.log;
import static org.junit.jupiter.api.Assertions.*;

/*
What's a Perfect Power anyway?

A perfect power is a classification of positive integers:

    In mathematics, a perfect power is a positive integer
    that can be expressed as an integer power of another positive integer.
    More formally, n is a perfect power if there exist natural numbers m > 1, and k > 1 such that mk = n.

Your task is to check wheter a given integer is a perfect power.
If it is a perfect power, return a pair m and k with mk = n as a proof.
Otherwise, return Nothing, Nil, null, NULL, None or your language's equivalent.

Note: For a perfect power, there might be several pairs.
For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid solutions.
However, the tests take care of this, so if a number is a perfect power, return any pair that proves it.

Examples

isPerfectPower(4) => new int[]{2,2}
isPerfectPower(5) => null
isPerfectPower(8) => new int[]{2,3}
isPerfectPower(9) => new int[]{3,2}

Categories : Fundamentals, Mathematics, Algorithms, Numbers
 */
public class PerfectPower {
    @Test
    public void test0() {
        assertNull(isPerfectPower(0), "0 is not a perfect number");
    }

    @Test
    public void test1() {
        assertNull(isPerfectPower(1), "1 is not a perfect number");
    }

    @Test
    public void test2() {
        assertNull(isPerfectPower(2), "2 is not a perfect number");
    }

    @Test
    public void test3() {
        assertNull(isPerfectPower(3), "3 is not a perfect number");
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{2, 2}, isPerfectPower(4), "4 = 2^2");
    }

    @Test
    public void test5() {
        assertNull(isPerfectPower(5), "5 is not a perfect power");
    }

    @Test
    public void test8() {
        assertArrayEquals(new int[]{2, 3}, isPerfectPower(8), "8 = 2^3");
    }

    @Test
    public void test9() {
        assertArrayEquals(new int[]{3, 2}, isPerfectPower(9), "9 = 3^2");
    }

    @Test
    public void testUpTo500() {
        int[] pp = {4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216,
                225, 243, 256, 289, 324, 343, 361, 400, 441, 484};
        for (int i : pp) {
            assertNotNull(isPerfectPower(i), i + " is a perfect power");
        }
    }

    @Test
    public void testRandomPerfectPowers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int m = rnd.nextInt(254) + 2;
            int k = (int) (rnd.nextDouble() * (log(Integer.MAX_VALUE) / log(m) - 2.0) + 2.0);
            int l = ipow(m, k);
            int[] r = isPerfectPower(l);
            assertNotNull(r, l + " is a perfect power");
            assertEquals(l, ipow(r[0], r[1]), r[0] + "^" + r[1] + "!=" + l);
        }
    }

    private static int ipow(int b, int e) {
        int p = 1;
        for (; e > 0; e >>= 1) {
            if ((e & 1) == 1) p *= b;
            b *= b;
        }
        return p;
    }

    @Test
    public void testRandomNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int l = rnd.nextInt(Integer.MAX_VALUE);
            int[] r = isPerfectPower(l);
            if (r != null) assertEquals(l, ipow(r[0], r[1]), r[0] + "^" + r[1] + "!=" + l);
        }
    }

    public static int[] isPerfectPower(int n) {
        // ...
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            int factor = 0;
            while (n % i == 0) {
                factor++;
                n /= i;
            }
            if (factor != 0) factors.put(i, factor);
        }
        System.out.println(factors);
        //if(factors.size() != 1) return null;
        return factors.entrySet().stream().findFirst().map(entry -> new int[]{entry.getKey(), entry.getValue()}).orElse(null);
    }
}