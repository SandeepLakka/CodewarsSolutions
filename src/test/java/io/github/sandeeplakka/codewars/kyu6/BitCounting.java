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
        assertEquals(0, countBits(0));
        assertEquals(1, countBits(4));
        assertEquals(3, countBits(7));
        assertEquals(3, countBits(26));
        assertEquals(2, countBits(9));
        assertEquals(2, countBits(10));

        assertEquals(14, countBits(77231418));
        assertEquals(11, countBits(12525589));
        assertEquals(8, countBits(3811));
        assertEquals(17, countBits(392902058));
        assertEquals(3, countBits(1044));
        assertEquals(10, countBits(10030245));
        assertEquals(16, countBits(183337941));
        assertEquals(14, countBits(20478766));
        assertEquals(9, countBits(103021));
        assertEquals(6, countBits(287));
        assertEquals(15, countBits(115370965));
        assertEquals(5, countBits(31));
        assertEquals(7, countBits(417862));
        assertEquals(12, countBits(626031));
        assertEquals(4, countBits(89));
        assertEquals(10, countBits(674259));

    }

    @Test
    public void testVersion2() {
        assertEquals(5, version2(1234));
        assertEquals(0, version2(0));
        assertEquals(5, version2(1234));
        assertEquals(1, version2(4));
        assertEquals(3, version2(7));
        assertEquals(3, version2(26));
        assertEquals(2, version2(9));
        assertEquals(2, version2(10));

        assertEquals(14, version2(77231418));
        assertEquals(11, version2(12525589));
        assertEquals(8, version2(3811));
        assertEquals(17, version2(392902058));
        assertEquals(3, version2(1044));
        assertEquals(10, version2(10030245));
        assertEquals(16, version2(183337941));
        assertEquals(14, version2(20478766));
        assertEquals(9, version2(103021));
        assertEquals(6, version2(287));
        assertEquals(15, version2(115370965));
        assertEquals(5, version2(31));
        assertEquals(7, version2(417862));
        assertEquals(12, version2(626031));
        assertEquals(4, version2(89));
        assertEquals(10, version2(674259));
    }

    public static int countBits(int n) {
        return Integer.bitCount(n);
    }

    public static int version2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }

}