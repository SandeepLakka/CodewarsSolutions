package io.github.sandeeplakka.codewars.kyu6;
/*
	Write a function that takes an integer as input,
	and returns the number of bits that are equal to
	one in the binary representation of that number.

	You can guarantee that input is non-negative.

	Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case

	Categories : Algorithms, Bits, Binary
*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCounting {

    @Test
    public void testCountBits() {
        assertEquals(5, countBits(1234));

    }

    public static int countBits(int n) {
        return Integer.bitCount(n);
    }

}