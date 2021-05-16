package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a buggy code to multiply two longs,
 * Kata requires one to fix the bug
 *
 * RCA: Missing semi-colon at the end of statement;
 *
 * Category: Bugs
 * https://www.codewars.com/kata/50654ddff44f800200000004
 */
public class Multiply {
    @Test
    public void testMultiply(){
        assertEquals(10.0, multiply(2.0, 5.0));
        assertEquals(0.0, multiply(2.0, 0.0));
        assertEquals(25.0, multiply(5.0, 5.0));
    }

    public static Double multiply(Double a, Double b) {
        return a * b;
    }
}