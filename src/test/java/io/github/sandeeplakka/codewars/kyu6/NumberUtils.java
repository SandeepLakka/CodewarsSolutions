package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;


/*
    A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised to the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).
    For example, take 153 (3 digits), which is narcissistic:
        1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    and 1652 (4 digits), which isn't:
        1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938

    The Challenge:
    Your code must return true or false (not 'true' and 'false') depending upon whether the given number is a Narcissistic number in base 10.

    Error checking for text strings or other invalid inputs is not required, only valid positive non-zero integers will be passed into the function.

    Categories: Algorithms
 */

public class NumberUtils {

    private static final int[] NARCISSISTIC_INTS = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634,
            8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818,
            9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
            472335975, 534494836, 912985153
    };

    @Test
    void fixedTests() {
        assertTrue(NumberUtils.isNarcissistic(153), "153 is narcissistic");
        assertTrue(NumberUtils.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(NumberUtils.isNarcissistic(112), "112 is not narcissistic");
        assertFalse(NumberUtils.isNarcissistic(10), "10 is not narcissistic");
        assertFalse(NumberUtils.isNarcissistic(Integer.MAX_VALUE), Integer.MAX_VALUE + " is not narcissistic");
    }

    @Test
    void randomTests() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int nrTests = 100_000;
        int[] testCases = Arrays.copyOf(NARCISSISTIC_INTS, nrTests);
        for (int i = NARCISSISTIC_INTS.length; i < nrTests; i++)
            testCases[i] = rnd.nextInt(Integer.MAX_VALUE);
        for (int i = 0; i < nrTests; i++) {
            int idx = rnd.nextInt(nrTests);
            int tmp = testCases[i];
            testCases[i] = testCases[idx];
            testCases[idx] = tmp;
        }

        for (int n : testCases) {
            boolean expected = Arrays.binarySearch(NARCISSISTIC_INTS, n) >= 0;
            assertEquals(expected, isNarcissistic(n), String.format("%d is %snarcissistic", n, expected ? "" : "not "));
        }
    }

    //-----------------------------------------------------

    public static boolean isNarcissistic(int number) {
        return Arrays.stream(("" + number).split("")).mapToInt(Integer::parseInt).map(v -> pow(v, number)).sum() == number;
    }

    private static int pow(int value, int number) {
        int len = ("" + number).length();
        int result = 1;
        for (int i = 0; i < len; i++) {
            result *= value;
        }
        return result;
    }

}