package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Some numbers have funny properties. For example:

    89 --> 8^1 + 9^2 = 89 * 1

    695 --> 6^2 + 9^3 + 5^4 = 1390 = 695 * 2

    46288 --> 4^3 + 6^4 + 2^5 + 8^6 + 8^7 = 2360688 = 46288 * 51

Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p

    we want to find a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n.

In other words:

    Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k

If it is the case we will return k, if not return -1.

Note: n and p will always be given as strictly positive integers.


Categories : Fundamentals, Mathematics, Algorithms, Numbers
 */
public class DigPow {

	@Test
	public void tests() {
		assertEquals(1, digPow(89, 1));
		assertEquals(-1, digPow(92, 1));
		assertEquals(51, digPow(46288, 3));
		assertEquals(9, digPow(114, 3));
		assertEquals(-1, digPow(46288, 5));
		assertEquals(1, digPow(135, 1));
		assertEquals(1, digPow(175, 1));
		assertEquals(1, digPow(518, 1));
		assertEquals(1, digPow(63761, 3));
		assertEquals(1, digPow(598, 1));
		assertEquals(1, digPow(1306, 1));
		assertEquals(1, digPow(2427, 1));
		assertEquals(1, digPow(2646798, 1));
		assertEquals(-1, digPow(3456789, 1));
		assertEquals(-1, digPow(3456789, 5));
		assertEquals(3, digPow(198, 1));
		assertEquals(3, digPow(249, 1));
		assertEquals(2, digPow(1377, 1));
		assertEquals(1, digPow(1676, 1));
		assertEquals(2, digPow(695, 2));
		assertEquals(19, digPow(1878, 2));
		assertEquals(5, digPow(7388, 2));
		assertEquals(1, digPow(47016, 2));
		assertEquals(1, digPow(542186, 2));
		assertEquals(5, digPow(261, 3));
		assertEquals(35, digPow(1385, 3));
		assertEquals(66, digPow(2697, 3));
		assertEquals(10, digPow(6376, 3));
		assertEquals(1, digPow(6714, 3));
		assertEquals(1, digPow(63760, 3));
		assertEquals(4, digPow(132921, 3));
		assertEquals(12933, digPow(10383, 6));
	}

	public static long digPow(int n, int p) {
		int[] digits = getDigits(n);
		long sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += Math.pow(digits[i], p + i);
		}
		return (sum % n == 0) ? sum / n : -1;
	}

	private static int[] getDigits(int num) {
		int[] digits = new int[String.valueOf(num).length()];
		//return String.valueOf(num).chars().map(val -> val - '0').toArray();
		return String.valueOf(num).chars().map(Character::getNumericValue).toArray();
	}

}
